package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.service.GradeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/grade")
public class GradeController {

    private GradeService gradeService;

    @GetMapping(path = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable(name = "studentId") Long studentId,
                                          @PathVariable(name = "courseId") Long courseId){
        return new ResponseEntity<>(gradeService.getGrade(studentId, courseId), HttpStatus.OK);
    }

    @PostMapping(path = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> saveGrade(@Valid @RequestBody Grade grade,
                                           @PathVariable(name = "studentId") Long studentId,
                                           @PathVariable(name = "courseId") Long courseId){
        return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
    }

    @PutMapping(path = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@Valid @RequestBody String score,
                                             @PathVariable(name = "studentId") Long studentId,
                                             @PathVariable(name = "courseId") Long courseId){
        return new ResponseEntity<>(gradeService.updateGrade(score, studentId, courseId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable(name = "studentId") Long studentId,
                                                  @PathVariable(name = "courseId") Long courseId){
        gradeService.deleteGrade(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }

    @GetMapping(path = "/student/{studentId}")
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable(name = "studentId") Long studentId){
        return new ResponseEntity<>(gradeService.getStudentGrades(studentId), HttpStatus.OK);
    }

    @GetMapping(path = "/course/{courseId}")
    public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable(name = "courseId") Long courseId){
        return new ResponseEntity<>(gradeService.getStudentGrades(courseId), HttpStatus.OK);
    }
}
