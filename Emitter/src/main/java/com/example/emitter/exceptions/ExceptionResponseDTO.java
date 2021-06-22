package com.example.emitter.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {

    private String message;
    private Timestamp timestamp;

}
