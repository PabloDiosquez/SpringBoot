package com.example.simple_api.controller;

import com.example.simple_api.entity.Department;
import com.example.simple_api.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(departmentService.getDepartment(id), HttpStatus.OK);
    }

    @GetMapping(path = "/code/{code}")
    public ResponseEntity<Department> getDepartmentByCode(@PathVariable(name = "code") String code){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }
}
