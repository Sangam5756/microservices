package com.sangam.user.service.exception;


import com.sangam.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ApiResponse> handleResourceAccessException(ResourceAccessException ex) {
        String message= ex.getMessage();
        ApiResponse response = ApiResponse.builder()
                .message("Service is Down")
                .status(true)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        return new ResponseEntity<ApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        String message = e.getMessage();

        ApiResponse response = ApiResponse.builder()
                .message(message)
                .status(true)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

    }


}
