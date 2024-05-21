package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
                //.guardianName("Winston")
                //.guardianEmail("winston1970@gmail.com")
                //.guardianMobile("555-1234-0001")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Sarah Connor")
                .email("sarahconnor1975@gmail.com")
                .mobile("555-0987-1111")
                .build();

        Student student = Student.builder()
                .firstname("John")
                .lastname("Connor")
                .email("johnconnor1990@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentsByFirstname(){
        List<Student> studentList = 
                studentRepository.findByFirstname("John");

        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentsFirstnameContaining(){
        List<Student> studentList = 
                studentRepository.findByFirstnameContaining("J");

        System.out.println("studentList = " + studentList);
    }
    
    @Test
    public void printStudentsBasedOnGuardianName(){
        List<Student> studentList = 
                studentRepository.findByGuardianName("Winston");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentsByFirstnameAndLastname(){
        Student student = 
                studentRepository.findByFirstnameAndLastname("John", "Wick");

        System.out.println("student = " + student);
    }
    
    @Test
    public void printStudentByEmailAddress(){
        Student student = 
                studentRepository.getStudentByEmailAddress("johnconnor1990@gmail.com");

        System.out.println("student = " + student);
    }
    @Test
    public void printStudentLastnameByEmailAddress(){
        System.out.println("Lastname = "
                + studentRepository.getStudentLastnameByEmailAddress("johnconnor1990@gmail.com"));
    }
    
    @Test
    public void printStudentByEmailAddressNative(){
        Student student = 
                studentRepository.getStudentByEmailAddressNative("johnconnor1990@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = 
                studentRepository.getStudentByEmailAddressNativeNamedParam("johnconnor1990@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentFirstnameByEmailAddress(){
        int updated =
                studentRepository.updateStudentFirstnameByEmailAddress("john", "johnconnor1990@gmail.com");
        System.out.println("updated = " + updated);
    }

}