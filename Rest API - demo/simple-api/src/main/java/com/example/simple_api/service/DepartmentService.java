package com.example.simple_api.service;

import com.example.simple_api.entity.Department;
import com.example.simple_api.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartment(int id);

    Department getDepartmentByCode(String code);

    List<Department> getDepartments();
}
