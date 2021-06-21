package com.example.emitter.controller;

import com.example.emitter.services.IEmitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emitter")
public class EmitterController {

    @Autowired
    IEmitterService emitterService;

    @GetMapping("/test1")
    public ResponseEntity<?> test1(){
        return new ResponseEntity<>(emitterService.executeCall1(), HttpStatus.OK);
    }

    @GetMapping("/test2")
    public ResponseEntity<?> test2(){
        return new ResponseEntity<>(emitterService.call2(), HttpStatus.OK);
    }

}
