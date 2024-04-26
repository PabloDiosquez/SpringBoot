package com.example.citiessv.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CityDTO {

    private int id;
    private String name;
    private String state;
    private String country;
    private String continent;
    private List<HotelDTO> hotels;
}
