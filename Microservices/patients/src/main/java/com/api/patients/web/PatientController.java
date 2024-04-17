package com.api.patients.web;

import com.api.patients.model.Patient;
import com.api.patients.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/patient")
public class PatientController {
    private PatientService patientService;
    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Patient>> getAllPatients(){
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable(name = "id") Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@PathVariable(name = "id") Long id,
                                                 @RequestBody Patient patient){
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    @GetMapping(path = "/license/{licenseNumber}")
    public ResponseEntity<Patient> getPatientByLicense(@PathVariable(name = "licenseNumber") String licenseNumber){
        return new ResponseEntity<>(patientService.getPatientByLicense(licenseNumber), HttpStatus.OK);
    }

}
