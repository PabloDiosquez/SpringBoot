package com.courses.app.service;

import com.courses.app.model.Content;
import com.courses.app.model.Course;

import java.util.List;

public interface ICourseService {
    void saveCourse(Course course);

    Course findCourseById(int id);

    List<Course> findAllCourses();

    void deleteCourseById(int id);

    List<Content> findAllContents(int id);

    void updateCourse(Course course);
}
