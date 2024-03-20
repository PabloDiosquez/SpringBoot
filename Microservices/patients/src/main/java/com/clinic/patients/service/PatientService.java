package com.clinic.patients.service;

import com.clinic.patients.entity.Patient;
import com.clinic.patients.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService{
    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int patientId) {
        return patientRepository.findById(patientId)
                .orElse(null);
    }

    @Override
    public void deletePatientById(int patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient findPatientByLicense(String patientLicense) {
        return patientRepository.findPatientByLicense(patientLicense);
    }
}
