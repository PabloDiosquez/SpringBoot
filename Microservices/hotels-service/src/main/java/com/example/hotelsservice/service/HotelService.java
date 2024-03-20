package com.example.hotelsservice.service;

import com.example.hotelsservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService{
    private final List<Hotel> hotels = new ArrayList<>();
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

    private void loadHotels(){
        hotels.add(new Hotel(1, "Hotel A", 4, 1));
        hotels.add(new Hotel(2, "Hotel B", 5, 2));
        hotels.add(new Hotel(3, "Hotel C", 3, 1));
        hotels.add(new Hotel(4, "Hotel D", 4, 3));
        hotels.add(new Hotel(5, "Hotel E", 5, 2));
        hotels.add(new Hotel(6, "Hotel F", 3, 1));
        hotels.add(new Hotel(7, "Hotel G", 4, 3));
        hotels.add(new Hotel(8, "Hotel H", 5, 2));
        hotels.add(new Hotel(9, "Hotel I", 3, 1));
        hotels.add(new Hotel(10, "Hotel J", 4, 3));
    }
}
