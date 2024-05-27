package com.example.simple_api.controller;

import com.example.simple_api.entity.Department;
import com.example.simple_api.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Department>> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(departmentService.getDepartment(id), HttpStatus.OK);
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<Department>> getDepartmentsByName(@PathVariable(name = "name") String name){
        return new ResponseEntity<>(departmentService.getDepartmentsByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/code/{code}")
    public ResponseEntity<Department> getDepartmentByCode(@PathVariable(name = "code") String code){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(departmentService.deleteDepartment(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/code/{code}")
    public ResponseEntity<Department> deleteDepartmentByCode(@PathVariable(name = "code") String code){
        return new ResponseEntity<>(departmentService.deleteDepartmentByCode(code), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(name = "id") int id,
                                                       @RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartment(id, department), HttpStatus.ACCEPTED);
    }
}
