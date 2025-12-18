package com.sangam.rating.service.services;

import com.sangam.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating> getAllRating();
    Rating getRatingById(Long id);

    List<Rating> getRatingByHotelId(Long hotelId);
    List<Rating> getRatingByUserId(Long userId);
}
