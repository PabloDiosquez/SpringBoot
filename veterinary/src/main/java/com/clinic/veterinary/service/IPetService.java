package com.clinic.veterinary.service;

import com.clinic.veterinary.model.Pet;

import java.util.List;

public interface IPetService {
    void savePet(Pet pet);

    Pet findPetById(int petId);

    List<Pet> findAllPets();

    void deletePetBYId(int petId);

    void updatePet(Pet pet);

    List<Pet> findAllPets(String specie, String breed);
}
