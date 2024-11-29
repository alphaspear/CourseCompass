package com.CourseCompass.DatasourceAgent.Controllers;

import com.CourseCompass.DatasourceAgent.Entity.dto.CourseInfoRecord;
import com.CourseCompass.DatasourceAgent.Service.CourseInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/course")
public record CourseController(CourseInfoService courseInfoService) {

    @GetMapping("/{id}")
    public ResponseEntity<CourseInfoRecord> getCourse(@PathVariable("id") String id) {
        CourseInfoRecord courseInfoRecord = courseInfoService.findById(Integer.parseInt(id));
        return new ResponseEntity<>(courseInfoRecord, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseInfoRecord>> getCourse() {
        List<CourseInfoRecord> courseInfoRecordList = courseInfoService.findAll();
        return new ResponseEntity<>(courseInfoRecordList, HttpStatus.OK);
    }

}
