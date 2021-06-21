package com.example.division.controller;

import com.example.division.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {

    @Autowired
    IOperationService operationService;

    @GetMapping("/test1")
    public ResponseEntity<Double> test1(){

        Double result = operationService.returnRandomProbability();
        if( result > 0.3 ){
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @GetMapping("/test2")
    public ResponseEntity<Double> test2() throws InterruptedException {

        Double result = operationService.returnRandomProbability();
        Thread.sleep((long) (result * 5000));
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
