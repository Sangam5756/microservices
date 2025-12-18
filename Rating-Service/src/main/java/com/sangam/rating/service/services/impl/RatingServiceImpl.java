package com.sangam.rating.service.services.impl;

import com.sangam.rating.service.entities.Rating;
import com.sangam.rating.service.exception.ResourceNotFoundException;
import com.sangam.rating.service.repositories.RatingRepository;
import com.sangam.rating.service.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

private final RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Ratings Not Found"));
    }

    @Override
    public List<Rating> getRatingByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }
}
