package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
