package com.example.division.exceptions;

import com.example.division.dtos.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleAArithmeticException (Exception e) {
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), Timestamp.from(Instant.now()));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
