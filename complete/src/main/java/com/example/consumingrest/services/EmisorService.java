package com.example.consumingrest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consumingrest.model.ResponseDTO;

@Service
public class EmisorService implements IEmisorService {
    private static final Logger log = LoggerFactory.getLogger(EmisorService.class);

    RestTemplateBuilder builder;
    RestTemplate rest;


    public EmisorService() {
        builder= new RestTemplateBuilder();
        builder.build();
        rest= new RestTemplate();
    }

    @Override
    public ResponseDTO llamar(){
        return rest.getForObject(
                "http://localhost:8081/test1", ResponseDTO.class);
    }

    @Override
    public ResponseDTO llamar2() {
        return rest.getForObject(
                "http://localhost:8081/test2", ResponseDTO.class);
    }
}
