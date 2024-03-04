package com.clinic.veterinary.service;

import com.clinic.veterinary.dto.PetDTO;
import com.clinic.veterinary.model.Pet;
import com.clinic.veterinary.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Pet> findAllPets() {
        return this.petRepository.findAll();
    }

    @Override
    public void deletePetBYId(int petId) {
        this.petRepository.deleteById(petId);
    }

    @Override
    public void updatePet(Pet pet) {
        this.petRepository.save(pet);
    }

    @Override
    public List<Pet> findAllPets(String specie, String breed) {
        List<Pet> pets = new ArrayList<>();
        for (Pet pet: findAllPets()) {
            if(pet.getSpecie().equals(specie) && pet.getBreed().equals(breed)){
                pets.add(pet);
            }
        }
        return pets;
    }

    @Override
    public PetDTO getPetData(int petId) {
        Pet pet = findPetById(petId);
        return new PetDTO(pet, pet.getOwner());
    }
}
