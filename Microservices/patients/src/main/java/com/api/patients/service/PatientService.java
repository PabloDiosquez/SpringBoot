package com.api.patients.service;

import com.api.patients.model.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatient(Long id);
    List<Patient> getAllPatients();
    Patient createPatient(Patient patient);
    void deletePatient(Long id);
    Patient updatePatient(Long id, Patient patient);
}
