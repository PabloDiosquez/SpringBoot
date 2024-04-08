package com.ltp.workbook91.service;

import com.ltp.gradesubmission.exception.StudentNotFoundException;
import com.ltp.workbook91.entity.Student;
import com.ltp.workbook91.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return studentRepository.findById(id).get();
        }
        throw new StudentNotFoundException(id);
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public List<Student> getStudents() {
        return (List<Student>)studentRepository.findAll();
    }
}
