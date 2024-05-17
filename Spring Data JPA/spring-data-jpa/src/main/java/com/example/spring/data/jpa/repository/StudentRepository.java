package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByFirstnameAndLastname(String firstname, String lastname);
    List<Student> findByLastname(String lastname);
    List<Student> findByFirstname(String firstname);
    List<Student> findByFirstnameContaining(String name);

    List<Student> findByGuardianName(String guardianName);
}
