package com.api.appointments.service;

import com.api.appointments.dto.PatientDTO;
import com.api.appointments.model.Appointment;
import com.api.appointments.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService{
    private AppointmentRepository appointmentRepository;

    private RestTemplate apiConsume;
    @Override
    public Appointment getAppointment(Long id) {
        return unwrapAppointment(appointmentRepository.findById(id), id);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment createAppointment(LocalDate date, String treatment, String patientLicense) {
        PatientDTO patient = apiConsume.getForObject("http://localhost:9001/patient/license/"+patientLicense, PatientDTO.class);
        assert patient != null;
        Appointment appointment = new Appointment();
        appointment.setDate(date);
        appointment.setTreatment(treatment);
        appointment.setPatientName(patient.getFirstname() + " " + patient.getLastname());
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment old = getAppointment(id);
        old.setDate(appointment.getDate());
        old.setTreatment(appointment.getTreatment());
        old.setPatientName(appointment.getPatientName());
        return appointmentRepository.save(old);
    }

    private Appointment unwrapAppointment(Optional<Appointment> entity, Long id){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new RuntimeException("The appointment with id '" + id + "' does not exist in our records.");
    }
}
