package com.clinic.veterinary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ownerId;
    private String licenseNumber;
    private String firstname;
    private String lastname;
    private String tel;
    @OneToMany(mappedBy="owner")
    private List<Pet> pets;
}
