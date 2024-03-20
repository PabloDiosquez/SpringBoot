package com.clinic.patients.service;

import com.clinic.patients.entity.Patient;

import java.util.List;

public interface IPatientService {
    void savePatient(Patient patient);

    List<Patient> getPatients();

    Patient getPatientById(int patientId);

    void deletePatientById(int patientId);

    void updatePatient(Patient patient);

    Patient findPatientByLicense(String patientLicense);
}
