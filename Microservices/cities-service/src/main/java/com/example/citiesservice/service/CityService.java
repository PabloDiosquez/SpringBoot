package com.example.citiesservice.service;

import com.example.citiesservice.dto.CityDTO;
import com.example.citiesservice.dto.HotelDTO;
import com.example.citiesservice.model.City;
import com.example.citiesservice.repository.ICityAPIClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    private ICityAPIClient cityAPIClient;

    private final List<City> cities = new ArrayList<>();

    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCitiesHotels")
    public CityDTO getCitiesHotels(String name, String country) throws Exception {
        City city = getCityByNameAndCountry(name, country);
        assert city != null;
        List<HotelDTO> hotels = cityAPIClient.getHotelsByCityId(city.getCityId());
        createException();
        return new CityDTO(city, hotels);
    }

    private City getCityByNameAndCountry(String name, String country){
        loadCities();
        for (City city: cities) {
            if(city.getName().equals(name) && city.getCountry().equals(country)){
                return city;
            }
        }
        return null;
    }

    public CityDTO fallbackGetCitiesHotels(Throwable throwable) {
        final int ERROR_ID = -1;
        final String ERROR_NAME = "Error";
        final String ERROR_STATE = "Error";
        final String ERROR_COUNTRY = "Error";
        final String ERROR_CONTINENT = "Error";
        final List<HotelDTO> ERROR_HOTELS = null;

        String errorMessage = throwable.getMessage();
        System.out.println("errorMessage = " + errorMessage);
        return new CityDTO(ERROR_ID, ERROR_NAME, ERROR_STATE, ERROR_COUNTRY, ERROR_CONTINENT, ERROR_HOTELS);
    }

    private void createException() throws Exception {
        throw new Exception();
    }

    private void loadCities(){
        cities.add(new City(1, "Tokyo", "", "Japan", "Asia"));
        cities.add(new City(2, "New York City", "New York", "USA", "North America"));
        cities.add(new City(3, "London", "", "UK", "Europe"));
        cities.add(new City(4, "Paris", "", "France", "Europe"));
        cities.add(new City(5, "Beijing", "", "China", "Asia"));
        cities.add(new City(6, "Sydney", "", "Australia", "Australia"));
        cities.add(new City(7, "Rio de Janeiro", "", "Brazil", "South America"));
        cities.add(new City(8, "Cairo", "", "Egypt", "Africa"));
        cities.add(new City(9, "Moscow", "", "Russia", "Europe"));
        cities.add(new City(10, "Mexico City", "", "Mexico", "North America"));
    }

}
