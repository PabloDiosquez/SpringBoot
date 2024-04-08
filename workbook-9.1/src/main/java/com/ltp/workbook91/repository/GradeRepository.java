package com.ltp.workbook91.repository;

import com.ltp.workbook91.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GradeRepository extends CrudRepository<Grade, Long> {

    Grade findByStudentIdAndCourseId(Long studentId, Long courseId);
}
