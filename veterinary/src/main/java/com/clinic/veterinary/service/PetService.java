package com.clinic.veterinary.service;

import com.clinic.veterinary.model.Pet;
import com.clinic.veterinary.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService implements IPetService{
    @Autowired
    private IPetRepository petRepository;

    @Override
    public void savePet(Pet pet) {
        this.petRepository.save(pet);
    }

    @Override
    public Pet findPetById(int petId) {
        return this.petRepository.findById(petId).orElse(null);
    }
}
