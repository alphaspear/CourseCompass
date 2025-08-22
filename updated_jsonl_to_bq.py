#!/usr/bin/env python3
import json
from google.cloud import bigquery, storage
from pathlib import Path

PROJECT_ID = "operating-aria-468908-b6"
DATASET_ID = "alpspr_dataset_01"
TABLE_ID = "jsonl_dump_4"
BUCKET_NAME = "my-bucket-sysco"
BLOB_NAME = "failed_batches.jsonl"

BATCH_SIZE = 300
FAILED_FILE = Path(__file__).parent / "failed_batches.jsonl"

# NEW: dictionary to summarize auto-flatten occurrences
auto_flattened_count = {}

def validate_and_clean(record, schema, line_num, errors):
    """Validate and clean a single JSON record against BigQuery schema."""
    cleaned = {}

    for key, value in record.items():
        if key not in schema:
            continue

        col_type, col_mode = schema[key]

        try:
            # Handle REPEATED (arrays)
            if col_mode == "REPEATED":
                if not value:
                    cleaned[key] = []
                elif isinstance(value, list):
                    if col_type == "STRING":
                        fixed_values = []
                        for v in value:
                            if isinstance(v, dict):
                                if v:  # take first non-empty key
                                    fixed_values.append(str(next(iter(v.values()))))
                                else:
                                    continue
                            else:
                                fixed_values.append(str(v))
                        cleaned[key] = fixed_values
                        if any(isinstance(v, dict) for v in value):
                            # NEW: increment count instead of logging per-line error
                            auto_flattened_count[key] = auto_flattened_count.get(key, 0) + 1
                    elif col_type in ("INTEGER", "INT64"):
                        fixed_values = []
                        for v in value:
                            if v is None:
                                continue
                            if isinstance(v, (int, float, str)) and str(v).isdigit():
                                fixed_values.append(int(v))
                            else:
                                errors.append((line_num, f"Invalid value in field '{key}': {v} (expected INT64)"))
                        cleaned[key] = fixed_values
                    else:
                        cleaned[key] = value
                else:
                    cleaned[key] = [value]
                continue

            # Scalars
            if value is None:
                cleaned[key] = None
            elif col_type in ("INTEGER", "INT64"):
                if isinstance(value, (int, float, str)) and str(value).isdigit():
                    cleaned[key] = int(value)
                else:
                    errors.append((line_num, f"Invalid value for field '{key}': {value} (expected INT64)"))
                    cleaned[key] = None
            elif col_type in ("FLOAT", "FLOAT64", "NUMERIC"):
                try:
                    cleaned[key] = float(value)
                except Exception:
                    errors.append((line_num, f"Invalid value for field '{key}': {value} (expected FLOAT64)"))
                    cleaned[key] = None
            elif col_type == "BOOLEAN":
                if str(value).lower() in ("true", "1", "yes", "false", "0", "no"):
                    cleaned[key] = str(value).lower() in ("true", "1", "yes")
                else:
                    errors.append((line_num, f"Invalid value for field '{key}': {value} (expected BOOLEAN)"))
                    cleaned[key] = None
            elif col_type == "TIMESTAMP":
                cleaned[key] = value  # let BigQuery parse it
            else:
                cleaned[key] = str(value)

        except Exception as e:
            errors.append((line_num, f"Error processing field '{key}': {value} ({e})"))
            cleaned[key] = None

    return cleaned


def main():
    bq_client = bigquery.Client(project=PROJECT_ID)
    storage_client = storage.Client(project=PROJECT_ID)

    # Get BigQuery table schema
    table_ref = f"{PROJECT_ID}.{DATASET_ID}.{TABLE_ID}"
    table = bq_client.get_table(table_ref)
    schema = {field.name: (field.field_type, field.mode) for field in table.schema}

    # Read JSONL from GCS
    print(f"Downloading {BLOB_NAME} from bucket {BUCKET_NAME}...")
    bucket = storage_client.bucket(BUCKET_NAME)
    blob = bucket.blob(BLOB_NAME)
    content = blob.download_as_text().splitlines()

    if not content:
        print("JSONL file is empty, nothing to load.")
        return

    print(f"Total lines read: {len(content)}")

    rows, errors = [], []

    for idx, line in enumerate(content, start=1):
        line = line.strip()
        if not line:
            continue
        try:
            record = json.loads(line)
        except json.JSONDecodeError as e:
            errors.append((idx, f"Invalid JSON format: {e}"))
            continue

        cleaned = validate_and_clean(record, schema, idx, errors)
        rows.append(cleaned)

    if errors:
        print(f"\nValidation finished with {len(errors)} issues:")
        for line_num, msg in errors[:20]:
            print(f"  Line {line_num}: {msg}")
        if len(errors) > 20:
            print(f"... and {len(errors)-20} more errors.\n")

    # NEW: summarize auto-flattened fields
    if auto_flattened_count:
        print("\nAuto-flattened ARRAY<STRUCT> to ARRAY<STRING> summary:")
        for field, count in auto_flattened_count.items():
            print(f"  - {field}: {count} times")

    if not rows:
        print("No valid rows found to insert.")
        return

    # Insert in batches
    print(f"\nInserting {len(rows)} rows into {table_ref} in batches of {BATCH_SIZE}...")
    failed_batches, failed_rows = [], []

    for i in range(0, len(rows), BATCH_SIZE):
        batch_num = i // BATCH_SIZE + 1
        batch = rows[i:i+BATCH_SIZE]
        errors_bq = bq_client.insert_rows_json(table, batch)
        if errors_bq:
            print(f"Batch {batch_num} had errors.")
            failed_batches.append(batch_num)
            failed_rows.extend(batch)
        else:
            print(f"Batch {batch_num} inserted successfully ({len(batch)} rows).")

    if failed_batches:
        print(f"\nBatches failed: {failed_batches}")
        with open(FAILED_FILE, "w") as f:
            for row in failed_rows:
                f.write(json.dumps(row) + "\n")
        print(f"Failed rows written to {FAILED_FILE}")
    else:
        print("\nAll batches inserted successfully!")

if __name__ == "__main__":
    main()
