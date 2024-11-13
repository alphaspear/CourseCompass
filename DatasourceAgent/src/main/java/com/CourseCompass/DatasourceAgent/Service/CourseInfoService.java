package com.CourseCompass.DatasourceAgent.Service;

import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;

public interface CourseInfoService {
    CourseInfoRecord findById(Integer id);
}
