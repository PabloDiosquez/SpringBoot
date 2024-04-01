package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {

    Grade findByStudentIdAndCourseId(Long studentId, Long courseId);
}