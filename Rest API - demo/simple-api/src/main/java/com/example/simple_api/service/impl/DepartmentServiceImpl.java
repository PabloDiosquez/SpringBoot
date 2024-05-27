package com.example.simple_api.service.impl;

import com.example.simple_api.entity.Department;
import com.example.simple_api.repository.DepartmentRepository;
import com.example.simple_api.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(int id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The ID is not in our records."));
    }

    @Override
    public Department getDepartmentByCode(String code) {
        return departmentRepository.findByCode(code);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department deleteDepartment(int id) {
        Department department = getDepartment(id);
        departmentRepository.deleteById(id);
        return department;
    }

    @Override
    public Department deleteDepartmentByCode(String code) {
        Department department = getDepartmentByCode(code);
        departmentRepository.deleteByCode(code);
        return department;
    }

    @Override
    public Department updateDepartment(int id, Department department) {
        Department oldie = getDepartment(id);
        if(id != oldie.getId()){
            throw new RuntimeException("The ID's do not match.");
        }
        Department.copy(oldie, department);
        return saveDepartment(oldie);
    }

}
