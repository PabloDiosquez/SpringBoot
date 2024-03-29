package com.clinic.veterinary.controller;

import com.clinic.veterinary.dto.PetDTO;
import com.clinic.veterinary.model.Pet;
import com.clinic.veterinary.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/pets")
public class PetController {
    @Autowired
    private IPetService petService;

    @PostMapping(path="/save")
    public String savePet(@RequestBody Pet pet){
        this.petService.savePet(pet);
        return "Success";
    }

    @GetMapping(path="/find")
    @ResponseBody
    public Pet findPetById(@RequestParam int petId){
        return this.petService.findPetById(petId);
    }

    @GetMapping(path="/find-all")
    @ResponseBody
    public List<Pet> findAllPets(){
        return this.petService.findAllPets();
    }

    @DeleteMapping(path="/delete")
    @ResponseBody
    public Pet deletePetById(@RequestParam int petId){
        return this.petService.deletePetBYId(petId);
    }

    @PutMapping(path="/update")
    @ResponseBody
    public Pet updatePet(@RequestBody Pet pet){
        this.petService.updatePet(pet);
        return findPetById(pet.getPetId());
    }

    @GetMapping(path="/find-all")
    @ResponseBody
    public List<Pet> findAllPets(@RequestParam String specie,
                                 @RequestParam String breed){
        return this.petService.findAllPets(specie, breed);
    }

    @GetMapping(path="/get-pet-data")
    @ResponseBody
    public PetDTO getPetData(@RequestParam int petId){
        return this.petService.getPetData(petId);
    }

}
