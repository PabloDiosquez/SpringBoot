package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.EntityNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    private StudentRepository studentRepository;

    @Override
    public Course getCourse(Long id) {
        return unwrapCourse(courseRepository.findById(id), id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Course course = getCourse(courseId);
        Student unwrappedstudent = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
        course.getStudents().add(unwrappedstudent);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Set<Student> getEnrolledStudents(Long id) {
        return getCourse(id).getStudents();
    }

    public static Course unwrapCourse(Optional<Course> entity, Long id){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new EntityNotFoundException(id, Course.class);
    }
}
