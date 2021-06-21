package com.example.consumingrest.controller;


import com.example.consumingrest.services.IEmisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emisor")
public class EmisorController {

    @Autowired
    IEmisorService emisorService;


    @GetMapping("/test1")
    public ResponseEntity<?> test1(){
        return new ResponseEntity<>(emisorService.llamar(), HttpStatus.OK);
    }

    @GetMapping("/test2")
    public ResponseEntity<?> test2(){
        return new ResponseEntity<>(emisorService.llamar2(), HttpStatus.OK);
    }
}
