package com.clinic.veterinary.controller;

import com.clinic.veterinary.model.Pet;
import com.clinic.veterinary.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
