package com.CourseCompass.DatasourceAgent.Entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseInfoRecord(
        @JsonProperty("course-id") Integer courseId,
        @JsonProperty("title") String title,
        @JsonProperty("overall-rating") String overallRating,
        @JsonProperty("topic") String topic,
        @JsonProperty("instructor") String instructor,
        @JsonProperty("video-duration-hr") Integer videoDurationHr,
        @JsonProperty("is-paid") String isPaid,
        @JsonProperty("price") String price
) {
}
