package com.clinic.veterinary.service;

import com.clinic.veterinary.model.Owner;
import com.clinic.veterinary.repository.IOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OwnerService implements IOwnerService{
    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public void saveOwner(Owner owner) {
        this.ownerRepository.save(owner);
    }

    @Override
    public Owner findOwnerById(int ownerId) {
        return this.ownerRepository.findById(ownerId).orElse(null);
    }
}
