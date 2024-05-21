package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("DSA")
                .credit(10)
                .courseMaterial(null)
                .build();

        Teacher teacher = Teacher.builder()
                .firstname("Johnny")
                .lastname("Cage")
                .courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }

}