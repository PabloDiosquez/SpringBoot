package com.meta.app.repository;

import com.meta.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByLastname(String lastname);
    List<Student> findAllByLastnameContaining(String characters);
}
