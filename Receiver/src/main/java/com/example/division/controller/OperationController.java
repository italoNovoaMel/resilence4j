package com.example.division.controller;

import com.example.division.dtos.ResponseDTO;
import com.example.division.service.IOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {

    @Autowired
    IOperationService operationService;

    private static final Logger logger = LoggerFactory.getLogger(OperationController.class);

    @GetMapping("/test1")
    public ResponseEntity<ResponseDTO> test1(){

        Double result = operationService.returnRandomProbability();
        logger.info("test1 executed");
        if( result > 0.3 ){
            return new ResponseEntity<>(
                    new ResponseDTO(result,HttpStatus.BAD_REQUEST.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(new ResponseDTO(result,HttpStatus.OK.getClass().getSimpleName()), HttpStatus.OK);
        }

    }

    @GetMapping("/test2")
    public ResponseEntity<ResponseDTO> test2() throws InterruptedException {

        Double result = operationService.returnRandomProbability();
        logger.info("test2 executed");
        Thread.sleep((long) (result * 5000));
        return new ResponseEntity<>(new ResponseDTO(result,HttpStatus.OK.getClass().getSimpleName()), HttpStatus.OK);

    }

}
