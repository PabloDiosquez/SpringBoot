package com.spring.springdatajpatutorial.repository;

import com.spring.springdatajpatutorial.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByFirstname(String firstname);
    List<Student> findByLastname(String lastname);
    List<Student> findByLastnameNotNull();
    List<Student> findByGuardianName(String guardianName);
    List<Student> findByLastnameContaining(String chars);

    //JPQL
    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmailAddress(String emailAddress);

    //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailAddress);
}
