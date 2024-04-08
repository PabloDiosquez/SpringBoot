package com.ltp.workbook91.service;

import com.ltp.gradesubmission.exception.GradeNotFoundException;
import com.ltp.workbook91.entity.Course;
import com.ltp.workbook91.entity.Grade;
import com.ltp.workbook91.entity.Student;
import com.ltp.workbook91.repository.CourseRepository;
import com.ltp.workbook91.repository.GradeRepository;
import com.ltp.workbook91.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService{

    private StudentRepository studentRepository;

    private GradeRepository gradeRepository;

    private CourseRepository courseRepository;
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if(grade.isPresent()){
            return grade.get();
        }
        throw new GradeNotFoundException(studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);
        if(student.isPresent() && course.isPresent()){
            grade.setStudent(student.get());
            grade.setCourse(course.get());
            return gradeRepository.save(grade);
        }
        throw new GradeNotFoundException(studentId, courseId);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if(grade.isPresent()){
            grade.get().setScore(score);
            return gradeRepository.save(grade.get());
        }
        throw new GradeNotFoundException(studentId, courseId);
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
        return (List<Grade>)gradeRepository.findAll();
    }
}
