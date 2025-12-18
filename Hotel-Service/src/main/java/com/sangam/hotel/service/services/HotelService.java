package com.sangam.hotel.service.services;

import com.sangam.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel findById(Long id);
    Hotel savedHotel(Hotel hotel);
    List<Hotel> getAllHotel();
}
