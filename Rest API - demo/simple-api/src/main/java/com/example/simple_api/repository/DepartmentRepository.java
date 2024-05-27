package com.example.simple_api.repository;

import com.example.simple_api.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByCode(String code);
}
