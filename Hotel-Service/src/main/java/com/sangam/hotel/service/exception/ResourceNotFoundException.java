package com.sangam.hotel.service.exception;

public class ResourceNotFoundException  extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException() {
        super("Resource Not Found");
    }
}
