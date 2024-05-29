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
                .address("Json Street 932")
                .code("CE-91Y")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department input = Department.builder()
                .name("CE")
                .address("Json Street 932")
                .code("CE-91Y")
                .build();

        Mockito.when(departmentService.saveDepartment(input))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"CE\",\n" +
                                "    \"address\": \"Json Street 932\",\n" +
                                "    \"code\": \"CE-91Y\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(department.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(department.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value(department.getAddress()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(department.getCode()));
    }

    @Test
    void getDepartment() throws Exception {
        Mockito.when(departmentService.getDepartment(department.getId()))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code")
                        .value(department.getCode()));
    }
}