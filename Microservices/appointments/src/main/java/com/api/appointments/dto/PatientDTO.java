package com.api.appointments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PatientDTO {
    private Long id;
    private String licenseNumber;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String telephone;
}
