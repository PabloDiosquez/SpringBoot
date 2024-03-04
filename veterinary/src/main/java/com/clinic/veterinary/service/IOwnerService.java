package com.clinic.veterinary.service;

import com.clinic.veterinary.model.Owner;

public interface IOwnerService {
    void saveOwner(Owner owner);

    Owner findOwnerById(int ownerId);
}
