package com.example.demo.controller;

import com.example.demo.Service.IResilenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResilenceController {

    @Autowired
    IResilenceService resilenceService;

    @GetMapping()
    public ResponseEntity<?> prueba(){
        return new ResponseEntity<>(resilenceService.process(23), HttpStatus.OK);
    }
}
