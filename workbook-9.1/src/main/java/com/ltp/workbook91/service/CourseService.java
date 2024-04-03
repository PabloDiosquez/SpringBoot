package com.ltp.workbook91.service;

import com.ltp.workbook91.entity.Course;
import com.ltp.workbook91.entity.Grade;

import java.util.List;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}
