package com.sangam.hotel.service.repositories;

import com.sangam.hotel.service.entities.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository  extends CrudRepository<Hotel,Long> {
}
