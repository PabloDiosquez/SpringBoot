package com.ltp.workbook91.service;

import com.ltp.workbook91.entity.Student;
import com.ltp.workbook91.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) {
        return null;
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public void deleteStudent(Long id) {

    }
    @Override
    public List<Student> getStudents() {
        return null;
    }
}
