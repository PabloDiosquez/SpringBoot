package com.example.simple_api.service;

import com.example.simple_api.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartment(int id);

    Department getDepartmentByCode(String code);

    List<Department> getDepartments();

    Department deleteDepartment(int id);
    Department deleteDepartmentByCode(String code);

    Department updateDepartment(int id, Department department);

    List<Department> getDepartmentsByName(String name);
}
