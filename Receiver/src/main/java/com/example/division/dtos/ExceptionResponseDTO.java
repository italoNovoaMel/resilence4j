package com.example.division.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {

    private String message;
    private Timestamp timestamp;

}
