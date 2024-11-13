package com.CourseCompass.DatasourceAgent.Entity.mapper;

import com.CourseCompass.DatasourceAgent.Entity.CourseInfo;
import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseInfoMapper {
    CourseInfo dtoToCourseInfo(CourseInfoRecord dto);

    default CourseInfoRecord courseInfoToDto(CourseInfo courseInfo) {
        return new CourseInfoRecord(
                courseInfo.getCourseId(),
                courseInfo.getTitle(),
                courseInfo.getOverallRating().toString(),
                courseInfo.getTopic(),
                courseInfo.getInstructor(),
                courseInfo.getVideoDurationHr(),
                courseInfo.getIsPaid(),
                courseInfo.getPrice().toString()
        );
    }
}
