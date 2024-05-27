package com.example.simple_api.service;

import com.example.simple_api.entity.Department;
import com.example.simple_api.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

public interface DepartmentService {
    Department saveDepartment(Department department);
}
