package com.CourseCompass.platform.Entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgentInfoRecord(
        @JsonProperty("id") Long id,
        @JsonProperty("base-url") String baseUrl,
        @JsonProperty("agent-id") UUID agentId,
        @JsonProperty("agent-name") String agentName,
        @JsonProperty("agent-registration-ts") LocalDateTime agentRegistrationTs
) {
}
