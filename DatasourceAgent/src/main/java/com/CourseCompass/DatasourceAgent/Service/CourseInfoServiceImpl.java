package com.CourseCompass.DatasourceAgent.Service;

import com.CourseCompass.DatasourceAgent.Entity.CourseInfo;
import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;
import com.CourseCompass.DatasourceAgent.Entity.mapper.CourseInfoMapper;
import com.CourseCompass.DatasourceAgent.Repository.CourseInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseInfoServiceImpl implements CourseInfoService{
    private final CourseInfoRepo courseInfoRepo;

    @Autowired
    public CourseInfoServiceImpl(CourseInfoRepo courseInfoRepo ) {
        this.courseInfoRepo = courseInfoRepo;
    }
    @Override
    public CourseInfoRecord findById(Integer id) {
        Optional<CourseInfo> optionalCourseInfo = courseInfoRepo.findById(id);
        if(optionalCourseInfo.isEmpty()){
            throw new NoSuchElementException("Course with id " + id + " not found");
        }
        CourseInfo courseInfo = optionalCourseInfo.get();
        return CourseInfoMapper.toDto(courseInfo);
    }

    @Override
    public List<CourseInfoRecord> findAll() {
        Iterable<CourseInfo> optionalCourseInfo = courseInfoRepo.findAll();
        List<CourseInfoRecord> courseInfoRecordList = new ArrayList<>();
        for (CourseInfo courseInfo : optionalCourseInfo) {
            courseInfoRecordList.add(CourseInfoMapper.toDto(courseInfo));
        }
        return courseInfoRecordList;
    }

}
