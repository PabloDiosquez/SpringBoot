package com.example.hotelsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Hotel {
    private int hotelId;
    private String name;
    private int stars;
    private int cityId;
}
