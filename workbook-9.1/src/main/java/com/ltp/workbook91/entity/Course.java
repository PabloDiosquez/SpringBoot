package com.ltp.workbook91.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Course {
    private Long id;
    private String subject;
    private String code;
    private String description;
}
