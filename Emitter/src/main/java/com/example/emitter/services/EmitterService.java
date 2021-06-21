package com.example.emitter.services;

import com.example.emitter.dtos.ResponseDTO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmitterService implements IEmitterService{

    private static final Logger log = LoggerFactory.getLogger(EmitterService.class);

    RestTemplateBuilder builder;
    RestTemplate rest;

    public EmitterService() {
        builder= new RestTemplateBuilder();
        builder.build();
        rest= new RestTemplate();
    }

    @Override
    public ResponseDTO call1() {
        return rest.getForObject(
                "http://localhost:8081/test1", ResponseDTO.class);
    }

    @Override
    public ResponseDTO call2() {
        return rest.getForObject(
                "http://localhost:8081/test2", ResponseDTO.class);
    }

}
