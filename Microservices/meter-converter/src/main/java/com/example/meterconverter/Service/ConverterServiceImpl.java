package com.example.meterconverter.Service;

import com.example.meterconverter.Service.ConverterService;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {
    @Override
    public double convertToCentimeters(double meters) {
        return 100*meters;
    }
}
