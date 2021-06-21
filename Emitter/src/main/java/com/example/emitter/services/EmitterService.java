package com.example.emitter.services;

import com.example.emitter.dtos.ResponseDTO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmitterService implements IEmitterService{

    private static final Logger log = LoggerFactory.getLogger(EmitterService.class);


    RestTemplate rest;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    public EmitterService() {

        rest= new RestTemplate();
    }

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseDTO call1() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:8081/test1";

//        try {
//            return circuitBreaker.run(() -> restTemplate.getForObject(url, ResponseDTO.class));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }

        return circuitBreaker.run(() -> restTemplate.getForObject(url, ResponseDTO.class),
                throwable -> new ResponseDTO(1D,throwable.getMessage()));
    }

    @Override
    public ResponseDTO call2() {
        return rest.getForObject(
                "http://localhost:8081/test2", ResponseDTO.class);
    }

}
