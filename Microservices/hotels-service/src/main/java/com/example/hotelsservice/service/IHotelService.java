package com.example.hotelsservice.service;

import com.example.hotelsservice.model.Hotel;
import java.util.List;

public interface IHotelService {

    List<Hotel> getHotelsByCityId(int cityId);
}
