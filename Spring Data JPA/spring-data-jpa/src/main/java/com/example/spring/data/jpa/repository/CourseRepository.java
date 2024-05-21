package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
