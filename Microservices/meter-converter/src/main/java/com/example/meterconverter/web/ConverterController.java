package com.example.meterconverter.web;

import com.example.meterconverter.Service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/converter")
public class ConverterController {
    @Autowired
    private ConverterService converterService;

    @GetMapping(path = "/meters/{meters}")
    public ResponseEntity<Double> convertToCentimeters(@PathVariable(name = "meters") Double meters){
        return new ResponseEntity<>(converterService.convertToCentimeters(meters), HttpStatus.OK);
    }
}
