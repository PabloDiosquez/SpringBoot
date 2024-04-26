package com.example.citiessv.dto;
import com.example.citiessv.model.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter @Setter
public class CityDTO {

    private int id;
    private String name;
    private String state;
    private String country;
    private String continent;
    private List<HotelDTO> hotels;

    public CityDTO(City city, List<HotelDTO> hotels){
        id = city.getId();
        name = city.getName();
        state = city.getState();
        country = city.getCountry();
        continent = city.getContinent();
        this.hotels = hotels;
    }
}
