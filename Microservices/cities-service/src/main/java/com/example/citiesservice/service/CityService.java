package com.example.citiesservice.service;

import com.example.citiesservice.dto.CityDTO;
import com.example.citiesservice.dto.HotelDTO;
import com.example.citiesservice.model.City;
import com.example.citiesservice.repository.ICityAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    private ICityAPIClient cityAPIClient;

    private List<City> cities = new ArrayList<>();

    @Override
    public CityDTO getCitiesHotels(String name, String country) {
        City city = getCityByNameAndCountry(name, country);
        assert city != null;
        List<HotelDTO> hotels = cityAPIClient.getHotelsByCityId(city.getCityId());
        return new CityDTO(city, hotels);
    }



    private City getCityByNameAndCountry(String name, String country){
        for (City city: cities) {
            if(city.getName().equals(name) && city.getCountry().equals(country)){
                return city;
            }
        }
        return null;
    }

}
