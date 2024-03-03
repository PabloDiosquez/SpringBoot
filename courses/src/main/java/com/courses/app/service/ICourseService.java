package com.courses.app.service;

import com.courses.app.model.Course;

import java.util.List;

public interface ICourseService {
    void saveCourse(Course course);

    Course findCourseById(int id);

    List<Course> findAllCourses();
}
