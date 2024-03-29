package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    @GetMapping(path = "/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable Long courseId){
        return new ResponseEntity<>(courseService.getCourse(courseId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(courseService.getCourses(),  HttpStatus.OK);
    }

}