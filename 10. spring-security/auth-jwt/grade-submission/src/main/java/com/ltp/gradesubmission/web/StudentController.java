package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable(name = "id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/courses")
    public ResponseEntity<Set<Course>> getEnrolledCourses(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(studentService.getEnrolledCourses(id), HttpStatus.OK);
    }
}
