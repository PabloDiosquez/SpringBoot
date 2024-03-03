package com.courses.app.controller;

import com.courses.app.repository.ICourseRepository;
import com.courses.app.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private ICourseService courseService;

}
