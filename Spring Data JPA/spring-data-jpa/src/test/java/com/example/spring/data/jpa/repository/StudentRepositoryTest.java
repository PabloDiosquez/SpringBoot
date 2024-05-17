package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstname("John")
                .lastname("Wick")
                .email("johnwick1980@gmail.com")
                .guardianName("Winston")
                .guardianEmail("winston1970@gmail.com")
                .guardianMobile("555-1234-0001")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

}