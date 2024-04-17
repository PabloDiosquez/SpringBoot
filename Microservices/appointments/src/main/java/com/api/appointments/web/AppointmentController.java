package com.api.appointments.web;

import com.api.appointments.dto.AppointmentDTO;
import com.api.appointments.model.Appointment;
import com.api.appointments.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(appointmentService.getAppointment(id), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return new ResponseEntity<>(appointmentService.getAllAppointments(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDTO appointment){
        return new ResponseEntity<>(appointmentService.createAppointment(appointment.getDate(),
                appointment.getTreatment(), appointment.getPatientLicense()), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/id")
    public ResponseEntity<HttpStatus> deleteAppointment(@PathVariable(name = "id") Long id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable(name = "id") Long id,
                                                         @RequestBody Appointment appointment){
        return new ResponseEntity<>(appointmentService.updateAppointment(id, appointment), HttpStatus.OK);
    }

}
