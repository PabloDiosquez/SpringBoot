package com.example.hotelsservice.web;

import com.example.hotelsservice.model.Hotel;
import com.example.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @GetMapping(path = "/{cityId}")
    public List<Hotel> getHotelsByCityId(@PathVariable int cityId){
        return hotelService.getHotelsByCityId(cityId);
    }
}
