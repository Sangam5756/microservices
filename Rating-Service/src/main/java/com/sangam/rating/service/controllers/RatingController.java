package com.sangam.rating.service.controllers;


import com.sangam.rating.service.entities.Rating;
import com.sangam.rating.service.repositories.RatingRepository;
import com.sangam.rating.service.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;



    @PostMapping
    public ResponseEntity<?> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<?> getRatingByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getRatingByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }


    @GetMapping
    public ResponseEntity<?> getRatings() {
        return ResponseEntity.ok(ratingService.getAllRating());
    }

}
