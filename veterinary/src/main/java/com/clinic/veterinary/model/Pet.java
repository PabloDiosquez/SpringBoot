package com.clinic.veterinary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Pet {
    private int petId;
    private String name;
    private String specie;
    private String breed;
    private String color;
}
