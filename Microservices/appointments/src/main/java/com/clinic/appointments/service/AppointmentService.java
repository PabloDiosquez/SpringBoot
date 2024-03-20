package com.clinic.appointments.service;

import com.clinic.appointments.entity.Appointment;
import com.clinic.appointments.entity.Patient;
import com.clinic.appointments.repository.IAppointmentRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService{
    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private RestTemplate consumeAPI;

    @Override
    public void saveAppointment(LocalDate date, String treatment, String patientLicense) {
        Patient patient = consumeAPI.
                getForObject("http://localhost:9001/api/patients/" + patientLicense, Patient.class);
        Appointment appointment = new Appointment();
        appointment.setDate(date);
        appointment.setTreatment(treatment);
        appointment.setPatientName(patient != null ? String.format("[%s, %s]", patient.getLastname(), patient.getFirstname()) : "NOT FOUND");
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElse(null);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointmentById(int appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
