package com.CourseCompass.DatasourceAgent.Entity.mapper;

import com.CourseCompass.DatasourceAgent.Entity.CourseInfo;
import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;

public class CourseInfoMapper {

    public static CourseInfoRecord toDto(CourseInfo courseInfo) {
        return new CourseInfoRecord(
                courseInfo.getCourseId(),
                courseInfo.getCourseTitle(),
                String.valueOf(courseInfo.getOverallRating()), // Convert Float to String
                courseInfo.getCourseSubject(),
                courseInfo.getInstructors(),
                (int) (Math.round(courseInfo.getVideoDurationHr() * 100.0) / 100.0), // Round to 2 decimal places if needed
                courseInfo.getIsPaid(),
                String.valueOf(courseInfo.getPrice()) // Convert Double to String
        );
    }
}
