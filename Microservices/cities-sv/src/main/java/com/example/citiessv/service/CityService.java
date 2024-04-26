package com.example.citiessv.service;

import com.example.citiessv.dto.CityDTO;

public interface CityService {

    CityDTO getHotelsByCity(String name, String country);
}
