package com.example.citiessv.web;

import com.example.citiessv.dto.CityDTO;
import com.example.citiessv.model.City;
import com.example.citiessv.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/cities")
public class CityController {

    private CityService cityService;

    @GetMapping(path = "/hotels")
    public ResponseEntity<CityDTO> getHotelsByCity(@RequestParam String name,
                                                   @RequestParam String country){
        return new ResponseEntity<>(cityService.getHotelsByCity(name, country), HttpStatus.OK);
    }
}
