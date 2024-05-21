package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printAllCourses(){
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher =
                Teacher.builder()
                        .firstname("Liu")
                        .lastname("Kan")
                        .build();

        Course course = Course.builder()
                .title("The Physics of Energy")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}