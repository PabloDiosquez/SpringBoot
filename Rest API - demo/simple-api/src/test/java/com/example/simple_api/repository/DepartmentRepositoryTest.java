package com.example.simple_api.repository;

import com.example.simple_api.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("ME")
                .address("Json Street 1981")
                .code("ME-0Z4")
                .build();

        testEntityManager.persist(department);
    }
    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department =
                departmentRepository.findById(1).get();
        assertEquals(department.getCode(), "ME-0Z4");
    }
}