package com.spring.springdatajpatutorial.repository;

import com.spring.springdatajpatutorial.entity.Guardian;
import com.spring.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .email("johnconnor@gmail.com")
                .firstname("John")
                .lastname("Connor")
                //.GuardianName("Sarah Connor")
                //.GuardianEmail("sarahconnor@gmail.com")
                //.GuardianMobile("555-111-9012")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Cormac O'Connor")
                .email("cormac1782@gmail.com")
                .mobile("555-111-9098")
                .build();

        Student student = Student.builder()
                .email("johnwick1990@gmail.com")
                .firstname("John")
                .lastname("Wick")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void printStudentsByFirstName(){
        List<Student> studentList =
                studentRepository.findByFirstname("John");

        System.out.println(studentList);
    }

    @Test
    public void printStudentsByLastName(){
        List<Student> studentList =
                studentRepository.findByLastname("Wick");

        System.out.println(studentList);
    }

    @Test
    public void printStudentsBasedOnGuardianName(){
        List<Student> studentList =
                studentRepository.findByGuardianName("Sarah Connor");

        System.out.println(studentList);
    }
    @Test
    public void printStudentsByLastNameContaining(){
        List<Student> studentList =
                studentRepository.findByLastnameContaining("C");

        System.out.println(studentList);
    }
}