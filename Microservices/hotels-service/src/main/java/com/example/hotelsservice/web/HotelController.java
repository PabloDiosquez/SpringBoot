package com.example.hotelsservice.web;

import com.example.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
    @Autowired
    private IHotelService hotelService;
}
