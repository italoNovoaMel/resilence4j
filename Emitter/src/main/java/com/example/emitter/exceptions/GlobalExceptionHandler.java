package com.example.emitter.exceptions;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CallNotPermittedException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCallNotPermittedException (CallNotPermittedException e) {
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), Timestamp.from(Instant.now()));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ExceptionResponseDTO> handleHttpClientErrorException (HttpClientErrorException e) {
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO("Bad request obtained", Timestamp.from(Instant.now()));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ExceptionResponseDTO> handleResourceAccessException (ResourceAccessException e) {
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), Timestamp.from(Instant.now()));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
