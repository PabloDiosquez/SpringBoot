package com.example.citiessv.web;

import com.example.citiessv.dto.CityDTO;
import com.example.citiessv.model.City;
import com.example.citiessv.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/cities")
public class CityController {

    private CityService cityService;

    @GetMapping(path = "/hotels/{name}/{country}")
    public ResponseEntity<CityDTO> getHotelsByCity(@PathVariable(name = "name") String name,
                                                   @PathVariable(name = "country") String country){
        return new ResponseEntity<>(cityService.getHotelsByCity(name, country), HttpStatus.OK);
    }
}
