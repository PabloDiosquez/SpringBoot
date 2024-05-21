package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByFirstnameAndLastname(String firstname, String lastname);
    List<Student> findByLastname(String lastname);
    List<Student> findByFirstname(String firstname);
    List<Student> findByFirstnameContaining(String name);
    List<Student> findByGuardianName(String guardianName);
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Student getStudentByEmailAddress(String email);

    @Query("SELECT s.lastname FROM Student s WHERE s.email = ?1")
    String getStudentLastnameByEmailAddress(String email);

    @Query(
            value = "SELECT * FROM `students` WHERE email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email);

    @Query(
            value = "SELECT * FROM `students` WHERE email_address = :emailAddress",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailAddress") String email);
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE students SET firstname = :firstname WHERE email_address = :email",
            nativeQuery = true
    )
    int updateStudentFirstnameByEmailAddress(@Param("firstname") String firstname,@Param("email") String email);
}
