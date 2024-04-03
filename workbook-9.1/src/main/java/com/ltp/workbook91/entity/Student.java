package com.ltp.workbook91.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Student {
    private Long id;
    private String name;
    private LocalDate birthDate;
}
