package com.sangam.user.service.exception;

public class ResourceNotFoundException  extends RuntimeException {

    ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException() {
        super("Resource Not Found");
    }
}
