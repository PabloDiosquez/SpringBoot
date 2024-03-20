package com.clinic.appointments.service;

import com.clinic.appointments.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {
    void saveAppointment(LocalDate date, String treatment, String patientLicense);
    Appointment findAppointmentById(int appointmentId);

    List<Appointment> findAllAppointments();

    void deleteAppointmentById(int appointmentId);

    void updateAppointment(Appointment appointment);

}
