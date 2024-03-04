package com.clinic.veterinary.service;

import com.clinic.veterinary.model.Pet;

public interface IPetService {
    void savePet(Pet pet);

    Pet findPetById(int petId);
}
