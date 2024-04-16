package com.api.patients.service;

import com.api.patients.model.Patient;

import com.api.patients.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService{
    private PatientRepository patientRepository;
    @Override
    public Patient getPatient(Long id) {
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return null;
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        return null;
    }
}
