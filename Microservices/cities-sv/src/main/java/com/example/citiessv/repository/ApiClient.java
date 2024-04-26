package com.example.citiessv.repository;

import com.example.citiessv.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-sv")
public interface ApiClient {
    @GetMapping(path = "/hotels/{cityId}")
    List<HotelDTO> getHotelsByCityId(@PathVariable(name = "cityId") int cityId);
}
