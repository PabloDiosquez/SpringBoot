package com.clinic.veterinary.repository;

import com.clinic.veterinary.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Integer> {
}
