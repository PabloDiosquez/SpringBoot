package com.courses.app.service;

import com.courses.app.model.Content;
import com.courses.app.model.Course;
import com.courses.app.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
