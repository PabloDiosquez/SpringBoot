package com.clinic.veterinary.controller;

import com.clinic.veterinary.model.Owner;
import com.clinic.veterinary.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
