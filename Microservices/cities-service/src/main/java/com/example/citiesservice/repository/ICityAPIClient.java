package com.example.citiesservice.repository;

import com.example.citiesservice.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("hotels-service")
public interface ICityAPIClient {
    @GetMapping(path = "/{cityId}")
    List<HotelDTO> getHotelsByCityId(@PathVariable(name = "cityId") int cityId);

}
