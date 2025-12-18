package com.sangam.user.service.services;


import com.sangam.user.service.entities.Hotel;
import com.sangam.user.service.entities.Rating;
import com.sangam.user.service.entities.User;
import com.sangam.user.service.external.services.HotelService;
import com.sangam.user.service.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    private final HotelService hotelService;

    @Override
    public User savedUser(User user) {
        long id = Math.abs(UUID.randomUUID().getMostSignificantBits());
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));

//        fetch the ratings
        Rating[] ratingsOfUser= restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);

         List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {

//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);


            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);


        return user;
    }
}
