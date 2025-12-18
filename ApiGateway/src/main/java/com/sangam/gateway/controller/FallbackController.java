package com.sangam.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

    @GetMapping("/fallback/user-service")
    public Mono<ResponseEntity<Map<String, Object>>> userServiceFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User Service is taking too long to respond or is down. Please try again later.");
        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/fallback/hotel-service")
    public Mono<ResponseEntity<Map<String, Object>>> hotelServiceFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hotel Service is taking too long to respond or is down. Please try again later.");
        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/fallback/rating-service")
    public Mono<ResponseEntity<Map<String, Object>>> ratingServiceFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rating Service is taking too long to respond or is down. Please try again later.");
        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }


}