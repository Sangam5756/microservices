package com.sangam.rating.service.repositories;

import com.sangam.rating.service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository  extends MongoRepository<Rating,Long> {


        List<Rating> findByHotelId(Long hotelId);
        List<Rating> findByUserId(Long userId);


}
