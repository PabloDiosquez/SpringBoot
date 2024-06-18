package com.meta.app.controller;

import com.meta.app.entity.Student;
import com.meta.app.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController {
    private StudentRepository studentRepository;

    @GetMapping(path = "/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
}
