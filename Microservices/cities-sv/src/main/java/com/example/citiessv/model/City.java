package com.example.citiessv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class City {
    private int id;
    private String name;
    private String state;
    private String country;
    private String continent;
}
