package com.api.appointments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AppointmentDTO {
    private LocalDate date;
    private String treatment;
    private String patientLicense;
}
