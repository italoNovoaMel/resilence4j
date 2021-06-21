//package com.example.demo.controller;
//
//import com.example.demo.services.IEmisorServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class EmisorController {
//
//    @Autowired
//    IEmisorServices iEmisorServices;
//
//
//    @GetMapping("/test1")
//    public ResponseEntity<?> test1() throws Exception {
//        return new ResponseEntity<>(iEmisorServices.test1(), HttpStatus.OK);
//    }
//}
