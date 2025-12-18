package com.sangam.user.service.services;

import com.sangam.user.service.entities.User;

import java.util.List;

public interface UserService {


    User savedUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

}
