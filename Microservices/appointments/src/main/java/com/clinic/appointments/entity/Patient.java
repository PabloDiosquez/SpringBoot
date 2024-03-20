package com.clinic.appointments.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Patient {
    private int patientId;
    private String license;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String telephone;
}
