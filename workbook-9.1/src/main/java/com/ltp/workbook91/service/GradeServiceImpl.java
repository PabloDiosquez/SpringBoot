package com.ltp.workbook91.service;

import com.ltp.workbook91.entity.Grade;
import com.ltp.workbook91.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService{

    private GradeRepository gradeRepository;
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        //return gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return null;
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        return null;
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        //Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        //grade.setScore(score);
        //return gradeRepository.save(grade);
        return null;
    }
    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteById(getGrade(studentId, courseId).getId());
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return null;
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return null;
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }
}
