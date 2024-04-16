package com.api.patients.service;

import com.api.patients.model.Patient;

import com.api.patients.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService{
    private PatientRepository patientRepository;
    @Override
    public Patient getPatient(Long id) {
        return unwrapPatient(patientRepository.findById(id), id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = getPatient(id);
        patientRepository.deleteById(patient.getPatientId());
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient old = getPatient(id);
        old.setLicenseNumber(patient.getLicenseNumber());
        old.setFirstname(patient.getFirstname());
        old.setLastname(patient.getLastname());
        old.setBirthDate(patient.getBirthDate());
        old.setTelephone(patient.getTelephone());
        return patientRepository.save(old);
    }

    private Patient unwrapPatient(Optional<Patient> entity, Long id){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new RuntimeException("The patient with id: '" + id + "' does not exist in our records.");
    }
}
