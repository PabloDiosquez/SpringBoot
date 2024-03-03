package com.courses.app.service;

import com.courses.app.model.Content;
import com.courses.app.model.Course;
import com.courses.app.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService{
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public Course findCourseById(int id) {
        return this.courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> findAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(int id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public List<Content> findAllContents(int id) {
        return this.findCourseById(id).getContents();
    }

    @Override
    public void updateCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public void addContent(int courseId, Content content) {
        this.findCourseById(courseId).getContents().add(content);
    }

    @Override
    public List<Course> findAllCoursesThatContains(String keyWord) {
        List<Course> courses = new ArrayList<>();
        for (Course course: this.findAllCourses()) {
            if(course.getName().contains(keyWord)){
                courses.add(course);
            }
        }
        return courses;
    }

}
