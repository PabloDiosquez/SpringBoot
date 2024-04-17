package com.api.patients.repository;

import com.api.patients.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.licenseNumber =: licenseNumber")
    Patient findByLicenseNumber(String licenseNumber);
}
