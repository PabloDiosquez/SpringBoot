package com.example.simple_api.service;

import com.example.simple_api.entity.Department;
import com.example.simple_api.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartment(int id);

    Department getDepartmentByCode(String code);

    List<Department> getDepartments();

    Department deleteDepartment(int id);
    Department deleteDepartmentByCode(String code);

    Department updateDepartment(int id, Department department);
}
