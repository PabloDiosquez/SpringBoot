package com.ltp.workbook91.repository;

import com.ltp.workbook91.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
