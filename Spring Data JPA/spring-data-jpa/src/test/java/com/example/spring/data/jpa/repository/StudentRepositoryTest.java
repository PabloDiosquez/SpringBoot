package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@AllArgsConstructor
@SpringBootTest
class StudentRepositoryTest {
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

}