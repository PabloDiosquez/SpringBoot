package com.clinic.veterinary.controller;

import com.clinic.veterinary.model.Owner;
import com.clinic.veterinary.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/owners")
public class OwnerController {
    @Autowired
    private IOwnerService ownerService;

    @PostMapping(path="/save")
    public String saveOwner(@RequestParam Owner owner){
        this.ownerService.saveOwner(owner);
        return "Success";
    }

    @GetMapping(path="/find")
    @ResponseBody
    public Owner findOwnerById(@RequestParam int ownerId){
        return this.ownerService.findOwnerById(ownerId);
    }

    @GetMapping(path="/find-all")
    @ResponseBody
    public List<Owner> findAllOwners(){
        return this.ownerService.findAllOwners();
    }

    @DeleteMapping(path="/delete")
    @ResponseBody
    public Owner deleteOwnerById(@RequestParam int ownerId){
        return this.ownerService.deleteOwnerById(ownerId);
    }

    @PutMapping(path="/update")
    @ResponseBody
    public Owner updateOwner(@RequestParam Owner owner){
        this.ownerService.updateOwner(owner);
        return findOwnerById(owner.getOwnerId());
    }
}
