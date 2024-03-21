package com.example.citiesservice.web;

import com.example.citiesservice.dto.CityDTO;
import com.example.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cities")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping(path = "/hotels/")
    public CityDTO getCityAndHotels(@RequestParam String cityName, @RequestParam String country) throws Exception {
        return cityService.getCitiesHotels(cityName, country);
    }
}
