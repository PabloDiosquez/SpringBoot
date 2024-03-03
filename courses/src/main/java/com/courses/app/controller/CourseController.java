package com.courses.app.controller;

import com.courses.app.model.Content;
import com.courses.app.model.Course;
import com.courses.app.repository.ICourseRepository;
import com.courses.app.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping(path="courses/save")
    public String saveCourse(@RequestBody Course course){
        this.courseService.saveCourse(course);
        return "Success";
    }

    @GetMapping(path="courses/find")
    public Course findCourseById(@RequestParam int id){
        return this.courseService.findCourseById(id);
    }

    @GetMapping(path="courses/findall")
    public List<Course> findAllCourses(){
        return this.courseService.findAllCourses();
    }

    @DeleteMapping(path="courses/delete")
    public String deleteCourseById(@RequestParam int id){
        this.courseService.deleteCourseById(id);
        return "Success";
    }

    @GetMapping(path="courses/findAllContents")
    public List<Content> findAllContents(@RequestParam int id){
        return this.courseService.findAllContents(id);
    }

}
