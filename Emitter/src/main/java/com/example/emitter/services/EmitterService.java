package com.example.emitter.services;

import com.example.emitter.dtos.ResponseDTO;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Service
public class EmitterService implements IEmitterService{

    private static final Logger log = LoggerFactory.getLogger(EmitterService.class);

    private CircuitBreaker circuitBreakerWithDefaultConfig;

    // private RestTemplateBuilder builder;
    private static RestTemplate rest;

    public EmitterService() {
        // builder= new RestTemplateBuilder();
        // builder.build();
        rest= new RestTemplate();

        // Create a custom configuration for a CircuitBreaker
        CircuitBreakerConfig circuitBreakerConfig;
        circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(70)
                .slowCallRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(10000))
                .slowCallDurationThreshold(Duration.ofSeconds(2))
                .permittedNumberOfCallsInHalfOpenState(3)
                .minimumNumberOfCalls(2)
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
                .slidingWindowSize(5)
                // .recordException(e -> INTERNAL_SERVER_ERROR.equals(getResponse().getStatus()))
                /*
                .recordException(e -> HttpStatus.BAD_REQUEST.equals(e.getMessage()))
                .recordExceptions(IOException.class, TimeoutException.class)
                */
                .recordExceptions( HttpClientErrorException.class )
                // .ignoreExceptions(BusinessException.class, OtherBusinessException.class)
                .build();

        // Create a CircuitBreakerRegistry with a custom global configuration
        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);

        // Get or create a CircuitBreaker from the CircuitBreakerRegistry
        // with the global default configuration
        this.circuitBreakerWithDefaultConfig =
                circuitBreakerRegistry.circuitBreaker("circuitBreaker1");

        /*
        Supplier<ResponseDTO> decoratedSupplier = CircuitBreaker
                .decorateSupplier(this.circuitBreakerWithDefaultConfig, EmitterService::call1);

        String result = Try.ofSupplier(decoratedSupplier)
                .recover(throwable ->  "" ).get();

         */

        // ResponseDTO result = circuitBreakerWithDefaultConfig.executeSupplier(EmitterService::call1);

    }

    public static ResponseDTO call1() {
        return rest.getForObject(
                "http://localhost:8081/receiver/test1", ResponseDTO.class);
    }

    public static ResponseDTO call2() {
        return rest.getForObject(
                "http://localhost:8081/receiver/test2", ResponseDTO.class);
    }

    @Override
    public ResponseDTO executeCall1() {
        ResponseDTO result = this.circuitBreakerWithDefaultConfig.executeSupplier(EmitterService::call1);
        return result;
    }

    @Override
    public ResponseDTO executeCall2() {
        ResponseDTO result = this.circuitBreakerWithDefaultConfig.executeSupplier(EmitterService::call2);
        return result;
    }

}
