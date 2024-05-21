package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Integer> {
}
