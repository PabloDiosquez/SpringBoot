package com.example.citiesservice.service;

import com.example.citiesservice.dto.CityDTO;

public interface ICityService {
    CityDTO getCitiesHotels(String name, String country) throws Exception;

}
