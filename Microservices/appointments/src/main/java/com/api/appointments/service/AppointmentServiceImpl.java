package com.api.appointments.service;

import com.api.appointments.model.Appointment;
import com.api.appointments.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService{
    private AppointmentRepository appointmentRepository;

    private RestTemplate apiConsume;
    @Override
    public Appointment getAppointment(Long id) {
        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }

    @Override
    public Appointment createAppointment(LocalDate date, String treatment, String patientLicense) {
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {

    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        return null;
    }
}
