package com.clinic.appointments.web;

import com.clinic.appointments.dto.AppointmentDTO;
import com.clinic.appointments.entity.Appointment;
import com.clinic.appointments.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/appointments")
public class AppointmentController {
    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<HttpStatus> saveAppointment(@RequestBody AppointmentDTO appointmentData){
        appointmentService.saveAppointment(
                appointmentData.getDate(),
                appointmentData.getTreatment(),
                appointmentData.getPatientLicense()
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{appointmentId}")
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable int appointmentId){
        return new ResponseEntity<>(appointmentService.findAppointmentById(appointmentId), HttpStatus.FOUND);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Appointment>> findAllAppointments(){
        return new ResponseEntity<>(appointmentService.findAllAppointments(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{appointmentId}")
    public ResponseEntity<HttpStatus> deleteAppointmentById(@PathVariable int appointmentId){
        appointmentService.deleteAppointmentById(appointmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/update/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable int appointmentId, @RequestBody Appointment appointment){
        appointmentService.updateAppointment(appointment);
        Appointment appointment1 =
                findAppointmentById(appointmentId).getBody();
        return new ResponseEntity<>(appointment1, HttpStatus.OK);
    }

}
