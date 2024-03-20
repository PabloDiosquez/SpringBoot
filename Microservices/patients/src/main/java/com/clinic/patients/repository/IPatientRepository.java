package com.clinic.patients.repository;

import com.clinic.patients.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

    @Query("SELECT patient FROM Patient patient WHERE patient.license = :license")
    Patient findPatientByLicense(String license);
}
