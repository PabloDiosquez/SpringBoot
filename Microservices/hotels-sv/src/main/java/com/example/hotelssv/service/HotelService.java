package com.example.hotelssv.service;

import com.example.hotelssv.model.Hotel;
import java.util.List;

public interface HotelService {

    List<Hotel> getHotelsByCityId(int cityId);
}
