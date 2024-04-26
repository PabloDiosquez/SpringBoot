package com.example.hotelssv.service;

import com.example.hotelssv.model.Hotel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class HotelServiceImpl implements HotelService{

    private List<Hotel> hotels = new ArrayList<>();
    @Override
    public List<Hotel> getHotelsByCityId(int cityId) {
        loadHotels();
        List<Hotel> hotelsCity = new ArrayList<>();
        for (Hotel hotel: hotels) {
            if(hotel.getCityId() == cityId){
                hotelsCity.add(hotel);
            }
        }
        return hotelsCity;
    }

    private void loadHotels() {
        hotels.add(new Hotel(1, "Paradise", 5, 1));
        hotels.add(new Hotel(2, "Sunset View", 4, 2));
        hotels.add(new Hotel(3, "Ocean Breeze", 4, 3));
        hotels.add(new Hotel(4, "Mountain Lodge", 3, 1));
        hotels.add(new Hotel(5, "City Lights Inn", 3, 2));
        hotels.add(new Hotel(6, "Riverfront Retreat", 4, 3));
        hotels.add(new Hotel(7, "Sunny Days Resort", 5, 1));
        hotels.add(new Hotel(8, "Forest Haven", 3, 2));
        hotels.add(new Hotel(9, "Lakeview Manor", 4, 3));
        hotels.add(new Hotel(10, "Tranquil Gardens", 5, 1));
    }
}
