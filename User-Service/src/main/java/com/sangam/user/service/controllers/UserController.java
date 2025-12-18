package com.sangam.user.service.controllers;


import com.sangam.user.service.entities.User;
import com.sangam.user.service.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {


    private final UserService userService;


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.savedUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }




}
