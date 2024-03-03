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

    @GetMapping(path="courses/find-all")
    public List<Course> findAllCourses(){
        return this.courseService.findAllCourses();
    }

    @DeleteMapping(path="courses/delete")
    public String deleteCourseById(@RequestParam int id){
        this.courseService.deleteCourseById(id);
        return "Success";
    }

    @GetMapping(path="courses/findAll-contents")
    public List<Content> findAllContents(@RequestParam int id){
        return this.courseService.findAllContents(id);
    }

    @PostMapping(path="courses/update")
    public Course updateCourse(@RequestBody Course course){
        this.courseService.updateCourse(course);
        return this.courseService.findCourseById(course.getIdCourse());
    }

    @PutMapping(path="courses/add-content")
    public String addContent(@RequestParam int courseId, @RequestBody Content content){
        this.courseService.addContent(courseId, content);
        return "Success";
    }

    @GetMapping(path="courses/find-all")
    public List<Course> findAllCoursesThatContains(@RequestParam String keyWord){
        return this.courseService.findAllCoursesThatContains(keyWord);
    }
}
