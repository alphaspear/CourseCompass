package com.CourseCompass.DatasourceAgent.Entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseInfoRecord(
        @JsonProperty("course-id") Integer courseId,
        @JsonProperty("title") String courseTitle,
        @JsonProperty("overall-rating") String overallRating,
        @JsonProperty("topic") String courseSubject,
        @JsonProperty("instructor") String instructors,
        @JsonProperty("video-duration-hr") Integer videoDurationHr,
        @JsonProperty("is-paid") String isPaid,
        @JsonProperty("price") String price
) {
}
