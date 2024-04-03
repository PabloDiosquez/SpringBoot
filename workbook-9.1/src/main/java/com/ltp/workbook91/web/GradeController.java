package com.ltp.workbook91.web;

import com.ltp.workbook91.entity.Grade;
import com.ltp.workbook91.service.GradeService;
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
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade,
                                           @PathVariable(name = "studentId") Long studentId,
                                           @PathVariable(name = "courseId") Long courseId){
        return new ResponseEntity<>(gradeService.saveGrade(grade,studentId, courseId), HttpStatus.CREATED);
    }

    @PutMapping(path = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade,
                                             @PathVariable(name = "studentId") Long studentId,
                                             @PathVariable(name = "courseId") Long courseId){
        return new ResponseEntity<>(gradeService.updateGrade(grade.getScore(), studentId, courseId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable(name = "studentId") Long studentId,
                                                 @PathVariable(name = "courseId") Long courseId){
        gradeService.deleteGrade(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/course/{courseId}")
    public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable(name = "courseId") Long courseId){
        return new ResponseEntity<>(gradeService.getCourseGrades(courseId), HttpStatus.OK);
    }

    @GetMapping(path = "/student/{studentId}")
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable(name = "studentId") Long studentId){
        return new ResponseEntity<>(gradeService.getStudentGrades(studentId), HttpStatus.OK);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }

}
