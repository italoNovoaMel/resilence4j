package com.example.demo.Service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ResilenceService implements IResilenceService{


    CircuitBreakerConfig config;


    @Override
    public int process(int i){
        return i;
    }


}
