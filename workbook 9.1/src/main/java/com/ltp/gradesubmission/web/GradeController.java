package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/grade")
public class GradeController {

    @GetMapping(path="/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(grade, HttpStatus.CREATED);
    }

    @PutMapping(path="/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @DeleteMapping(path="/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path="/student/{studentId}")
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path="/student/{courseId}")
    public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
