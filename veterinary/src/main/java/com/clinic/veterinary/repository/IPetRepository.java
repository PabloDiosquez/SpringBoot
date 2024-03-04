package com.clinic.veterinary.repository;

import com.clinic.veterinary.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Integer> {
}
