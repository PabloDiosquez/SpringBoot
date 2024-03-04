package com.clinic.veterinary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int petId;
    private String name;
    private String specie;
    private String breed;
    private String color;
    @ManyToOne
    @JoinColumn(name="ownerId")
    private Owner owner;
}
