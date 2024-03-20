package com.example.meterconverter.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService{
    @Override
    public Double convertMetersToCentimeters(double meters) {
        return meters*100;
    }
}
