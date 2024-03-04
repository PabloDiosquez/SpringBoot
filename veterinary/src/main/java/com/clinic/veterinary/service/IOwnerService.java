package com.clinic.veterinary.service;

import com.clinic.veterinary.model.Owner;

import java.util.List;

public interface IOwnerService {
    void saveOwner(Owner owner);

    Owner findOwnerById(int ownerId);

    List<Owner> findAllOwners();

    Owner deleteOwnerById(int ownerId);

    void updateOwner(Owner owner);
}
