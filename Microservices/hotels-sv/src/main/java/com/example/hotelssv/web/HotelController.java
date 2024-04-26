package com.example.hotelssv.web;

import com.example.hotelssv.model.Hotel;
import com.example.hotelssv.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/hotels")
public class HotelController {

    private HotelService hotelService;

    @GetMapping(path = "/{cityId}")
    public ResponseEntity<List<Hotel>> getHotelsByCityId(@PathVariable(name = "cityId") int cityId){
        return new ResponseEntity<>(hotelService.getHotelsByCityId(cityId), HttpStatus.OK);
    }
}
