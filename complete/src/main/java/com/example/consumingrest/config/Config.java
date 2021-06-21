package com.example.consumingrest.config;


import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.beans.factory.annotation.Configurable;



@Configurable
public class Config {


    public Config() {

        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("backendName");
    }


}
