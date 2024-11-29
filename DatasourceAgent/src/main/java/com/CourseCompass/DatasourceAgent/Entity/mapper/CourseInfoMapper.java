package com.CourseCompass.DatasourceAgent.Entity.mapper;

import com.CourseCompass.DatasourceAgent.Entity.CourseInfo;
import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;
import org.springframework.context.annotation.Bean;


public class CourseInfoMapper {

    public static CourseInfoRecord toDto(CourseInfo courseInfo) {
        return new CourseInfoRecord(
                courseInfo.getCourseId(),
                courseInfo.getCourseTitle(),
                String.valueOf(courseInfo.getOverallRating()), // Convert Float to String
                courseInfo.getCourseSubject(),
                courseInfo.getInstructors(),
                (int) (Math.round(courseInfo.getVideoDurationHr() * 100.0) / 100.0), // Rounded to two decimal places
                courseInfo.getIsPaid(),
                String.valueOf(courseInfo.getPrice()) // Convert Double to String
        );
    }
}
