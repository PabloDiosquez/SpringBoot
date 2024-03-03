package com.courses.app.controller;

import com.courses.app.model.Course;
import com.courses.app.repository.ICourseRepository;
import com.courses.app.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping(path="courses/save")
    public String saveCourse(@RequestBody Course course){
        this.courseService.saveCourse(course);
        return "Success";
    }

}
