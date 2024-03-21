package com.example.citiesservice.dto;

import com.example.citiesservice.model.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CityDTO {
    private int cityId;
    private String name;
    private String state;
    private String country;
    private String continent;
    private List<HotelDTO> hotels;

    public CityDTO(City city, List<HotelDTO> hotels){
        cityId = city.getCityId();
        name = city.getName();
        state = city.getState();
        country = city.getCountry();
        continent = city.getContinent();
        this.hotels = hotels;
    }
}
