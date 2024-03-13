package com.spring.springdatajpatutorial.repository;

import com.spring.springdatajpatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :email",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET firstname = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    void updateStudentFirstnameByEmail(String firstname, String email);



}
