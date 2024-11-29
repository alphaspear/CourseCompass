package com.CourseCompass.DatasourceAgent.Service;

import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;

import java.util.List;

public interface CourseInfoService {
    CourseInfoRecord findById(Integer id);
    List<CourseInfoRecord> findAll();
}
