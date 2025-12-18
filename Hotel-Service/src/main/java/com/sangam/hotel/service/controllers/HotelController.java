package com.sangam.hotel.service.controllers;


import com.sangam.hotel.service.entities.Hotel;
import com.sangam.hotel.service.services.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {


    private  final HotelService hotelService;

    @PostMapping
    public ResponseEntity<?> addHotel(@RequestBody  Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.savedHotel(hotel));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getHotel(@PathVariable Long id) {
        return ResponseEntity.ok().body(hotelService.findById(id));
    }

    @GetMapping
    public  ResponseEntity<?> getAllHotels() {
        return ResponseEntity.ok().body(hotelService.getAllHotel());
    }


}
