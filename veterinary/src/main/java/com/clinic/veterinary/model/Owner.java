package com.clinic.veterinary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Owner {
    private int ownerId;
    private String licenseNumber;
    private String firstname;
    private String lastname;
    private String tel;
}
