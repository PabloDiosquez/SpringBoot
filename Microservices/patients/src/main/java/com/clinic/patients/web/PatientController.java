package com.clinic.patients.web;

import com.clinic.patients.entity.Patient;
import com.clinic.patients.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/patients")
public class PatientController {
    @Autowired
    private IPatientService patientService;

    @PostMapping(path = "/save")
    public ResponseEntity<HttpStatus> savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients =
                patientService.getPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping(path = "/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId){
        Patient patient =
                patientService.getPatientById(patientId);
        return new ResponseEntity<>(patient, HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/{patientId}")
    public ResponseEntity<HttpStatus> deletePatientById(@PathVariable int patientId){
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/update/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int patientId, @RequestBody Patient patient){
        patientService.updatePatient(patient);
        return new ResponseEntity<>(patientService.getPatientById(patientId), HttpStatus.OK);
    }

    @GetMapping(path = "/{patientLicense}")
    public ResponseEntity<Patient> findPatientByLicense(@PathVariable String patientLicense){
        Patient patient =
                patientService.findPatientByLicense(patientLicense);
        return new ResponseEntity<>(patient, HttpStatus.FOUND);
    }
}
