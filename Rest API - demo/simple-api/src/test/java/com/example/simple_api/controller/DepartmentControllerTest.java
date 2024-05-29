package com.example.simple_api.controller;

import com.example.simple_api.entity.Department;
import com.example.simple_api.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .id(1)
                .name("CE")
                .address("Graddle Street 932")
                .code("CE-91Y")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department input = Department.builder()
                .name("CE")
                .address("Graddle Street 932")
                .code("CE-91Y")
                .build();

        Mockito.when(departmentService.saveDepartment(input))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"CE\",\n" +
                        "    \"address\": \"Graddle Street 932\",\n" +
                        "    \"code\": \"CE-91Y\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getDepartment() {
    }
}