package com.example.simple_api.service;

import com.example.simple_api.entity.Department;
import com.example.simple_api.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .id(2)
                .name("IT")
                .address("Json Street 1982")
                .code("IT-0X2")
                .build();

        Mockito.when(departmentRepository.findByCode("IT-0X2"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get data based on Valid code")
    public void whenValidDepartmentCode_thenDepartmentShouldFound(){
        String code = "IT-0X2";
        Department departmentFound =
                departmentService.getDepartmentByCode(code);
        System.out.println("departmentFound = " + departmentFound);
        assertEquals(code, departmentFound.getCode());
    }
}