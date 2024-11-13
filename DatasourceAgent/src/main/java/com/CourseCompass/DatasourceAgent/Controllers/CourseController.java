package com.CourseCompass.DatasourceAgent.Controllers;

import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;
import com.CourseCompass.DatasourceAgent.Entity.mapper.CourseInfoMapper;
import com.CourseCompass.DatasourceAgent.Repository.CourseInfoRepo;
import com.CourseCompass.DatasourceAgent.Service.CourseInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record CourseController(CourseInfoService courseInfoService) {

    @GetMapping("/course/{id}")
    public ResponseEntity<CourseInfoRecord> getCourse(@PathVariable("id") String id) {
        CourseInfoRecord courseInfoRecord = courseInfoService.findById(Integer.getInteger(id));
        return new ResponseEntity<>(courseInfoRecord, HttpStatus.OK);
    }
}
