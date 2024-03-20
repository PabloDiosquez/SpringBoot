package com.example.meterconverter.web;

import com.example.meterconverter.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/converter")
public class ConverterController {
    @Autowired
    private IConverterService converterService;

    @GetMapping(path="/meters/{meters}")
    public Double convertMetersToCentimeters(@PathVariable double meters){
        return converterService.convertMetersToCentimeters(meters);
    }
}
