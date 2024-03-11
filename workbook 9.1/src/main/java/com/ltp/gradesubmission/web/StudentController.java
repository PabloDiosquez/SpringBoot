package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(path="/student/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/student")
    public ResponseEntity<Student> saveStudent(@RequestParam Student student){
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping(path="/student/{studentId}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path="/student/all")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
