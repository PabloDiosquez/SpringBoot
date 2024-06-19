package com.meta.app.controller;

import com.meta.app.entity.Student;
import com.meta.app.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private StudentRepository studentRepository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(studentRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found in our records")),
                HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/{lastname}")
    public ResponseEntity<List<Student>> getAllStudentsByLastname(@PathVariable(name = "lastname") String lastname){
        return new ResponseEntity<>(studentRepository.findAllByLastname(lastname), HttpStatus.OK);
    }

    @GetMapping(path = "/search-characters/{characters}")
    public ResponseEntity<List<Student>> getAllStudentsByLastnameContaining(@PathVariable(name = "characters") String characters){
        return new ResponseEntity<>(studentRepository.findAllByLastnameContaining(characters), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(name = "id") int id){
        Student deleted = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found in our records"));
        studentRepository.deleteById(id);
        return new ResponseEntity<>(deleted, HttpStatus.ACCEPTED);
    }
}
