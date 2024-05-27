package com.example.simple_api.controller;

import com.example.simple_api.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class DepartmentController {
    private DepartmentService departmentService;
}
