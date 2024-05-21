package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Introduction to Biology - 012")
                .credit(6)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("https://ocw.mit.edu/courses/7-012-introduction-to-biology/")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }
}