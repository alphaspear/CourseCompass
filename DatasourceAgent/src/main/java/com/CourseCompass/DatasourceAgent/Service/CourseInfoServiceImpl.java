package com.CourseCompass.DatasourceAgent.Service;

import com.CourseCompass.DatasourceAgent.Entity.CourseInfo;
import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;
import com.CourseCompass.DatasourceAgent.Entity.mapper.CourseInfoMapper;
import com.CourseCompass.DatasourceAgent.Repository.CourseInfoRepo;

import java.util.NoSuchElementException;
import java.util.Optional;

public class CourseInfoServiceImpl implements CourseInfoService{
    private final CourseInfoRepo courseInfoRepo;
    private final CourseInfoMapper courseInfoMapper;

    public CourseInfoServiceImpl(CourseInfoRepo courseInfoRepo, CourseInfoMapper courseInfoMapper) {
        this.courseInfoRepo = courseInfoRepo;
        this.courseInfoMapper = courseInfoMapper;
    }
    @Override
    public CourseInfoRecord findById(Integer id) {
        Optional<CourseInfo> optionalCourseInfo = courseInfoRepo.findById(id);
        if(optionalCourseInfo.isEmpty()){
            throw new NoSuchElementException("Course with id " + id + " not found");
        }
        CourseInfo courseInfo = optionalCourseInfo.get();
        return courseInfoMapper.courseInfoToDto(courseInfo);
    }
}
