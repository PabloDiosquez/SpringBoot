package com.example.citiesservice.web;

import com.example.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private ICityService cityService;
}
