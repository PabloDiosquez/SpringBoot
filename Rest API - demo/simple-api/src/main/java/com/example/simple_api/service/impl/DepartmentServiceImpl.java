package com.example.simple_api.service.impl;

import com.example.simple_api.entity.Department;
import com.example.simple_api.exception.DepartmentNotFoundException;
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
        return unwrap(departmentRepository.findById(id), id);
    }
    @Override
    public List<Department> getDepartmentsByName(String name) {
        //return departmentRepository.findByName(name);
        return departmentRepository.findByNameIgnoreCase(name);
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
        Department.copy(oldie, department);
        return saveDepartment(oldie);
    }

    private Department unwrap(Optional<Department> optional, int id){
        if(optional.isPresent()){
            return optional.get();
        }
        throw new DepartmentNotFoundException("The ID is not in our records.");
    }

}
