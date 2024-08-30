package com.music.school.controller;

import com.music.school.response.CourseBatchDetailsResponseDTO;
import com.music.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {


    @Autowired
    CourseService courseService;


    @GetMapping("/batch/get")
    ResponseEntity<CourseBatchDetailsResponseDTO> getAllCourse(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseService.getAllCoursesAndBatchDetails());
    }
}
