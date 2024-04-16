package com.api.appointments.service;

import com.api.appointments.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    Appointment getAppointment(Long id);
    List<Appointment> getAllAppointments();
    Appointment createAppointment(LocalDate date, String treatment, String patientLicense);
    void deleteAppointment(Long id);
    Appointment updateAppointment(Long id, Appointment appointment);
}
