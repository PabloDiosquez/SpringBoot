package com.clinic.veterinary.dto;

import com.clinic.veterinary.model.Owner;
import com.clinic.veterinary.model.Pet;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PetDTO {
    private String petName;
    private String specie;
    private String breed;
    private String ownerFirstname;
    private String ownerLastname;

    public PetDTO(Pet pet, Owner owner){
        this.petName = pet.getName();
        this.specie = pet.getSpecie();
        this.breed = pet.getBreed();
        this.ownerFirstname = owner.getFirstname();
        this.ownerLastname = owner.getLastname();
    }
}
