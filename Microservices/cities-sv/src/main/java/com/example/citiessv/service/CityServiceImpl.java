package com.example.citiessv.service;

import com.example.citiessv.dto.CityDTO;
import com.example.citiessv.dto.HotelDTO;
import com.example.citiessv.model.City;
import com.example.citiessv.repository.ApiClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    private final List<City> cities = new ArrayList<>();
    @Autowired
    private ApiClient hotelApiClient;

    @Override
    @CircuitBreaker(name = "hotels-sv", fallbackMethod = "fallbackGetHotelsByCity")
    @Retry(name = "hotels-sv")
    public CityDTO getHotelsByCity(String name, String country) {
        City city = findCityByNameAndCountry(name, country);
        //createException();
        return new CityDTO(city, hotelApiClient.getHotelsByCityId(city.getId()));
    }

    public CityDTO fallbackGetHotelsByCity(Throwable throwable){
        return new CityDTO(new City(-1, "ERROR", "ERROR", "ERROR", "ERROR"), null);
    }

    public void createException(){
        throw new RuntimeException();
    }

    private City findCityByNameAndCountry(String name, String country){
        loadCities();
        for (City city: cities) {
            if(city.getName().equals(name) && city.getCountry().equals(country)){
                return city;
            }
        }
        throw new RuntimeException("The city does not exist in our records.");
    }

    private void loadCities() {
        cities.add(new City(1, "New York", "Manhattan", "USA", "America"));
        cities.add(new City(2, "London", "Greater London", "UK", "Europe"));
        cities.add(new City(3, "Paris", "Île-de-France", "France", "Europe"));
        cities.add(new City(4, "Tokyo", "Tokyo Metropolis", "Japan", "Asia"));
        cities.add(new City(5, "Sydney", "New South Wales", "Australia", "Oceania"));
    }
}
