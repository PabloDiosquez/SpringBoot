package com.example.simple_api.service.impl;

import com.example.simple_api.repository.DepartmentRepository;
import com.example.simple_api.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
}
