package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printAllCourses(){
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher =
                Teacher.builder()
                        .firstname("Liu")
                        .lastname("Kan")
                        .build();

        Course course = Course.builder()
                .title("The Physics of Energy")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Page<Course> coursePage = courseRepository.findAll(firstPageWithThreeRecords);

        List<Course> courses = coursePage.getContent();
        long totalElements = coursePage.getTotalElements();
        long totalPages = coursePage.getTotalPages();

        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllPagingAndSorting(){
        Pageable sortByTitleDesc =
                PageRequest.of(0, 2, Sort.by("title").descending());
        Pageable sortByTitleAsc =
                PageRequest.of(0, 2, Sort.by("title"));

        Page<Course> coursePage =
                courseRepository.findAll(sortByTitleDesc);

        List<Course> courses = coursePage.getContent();
        long totalElements = coursePage.getTotalElements();
        long totalPages = coursePage.getTotalPages();

        System.out.println("courses = " + courses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining("Bio", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

}