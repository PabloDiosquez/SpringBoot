package com.ltp.workbook91.service;

import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.workbook91.entity.Course;
import com.ltp.workbook91.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            return courseRepository.findById(id).get();
        }
        throw new CourseNotFoundException(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }
}
