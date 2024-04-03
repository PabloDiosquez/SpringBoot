package com.ltp.gradesubmission.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Student {

    private Long id;
    private String name;
    private LocalDate birthDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
