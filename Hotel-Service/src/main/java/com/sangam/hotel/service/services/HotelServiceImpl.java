package com.sangam.hotel.service.services;

import com.sangam.hotel.service.entities.Hotel;
import com.sangam.hotel.service.exception.ResourceNotFoundException;
import com.sangam.hotel.service.repositories.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found"));
    }

    @Override
    public Hotel savedHotel(Hotel hotel) {
        Long hotelId = Math.abs(UUID.randomUUID().getMostSignificantBits());
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return (List<Hotel>) hotelRepository.findAll();
    }
}

