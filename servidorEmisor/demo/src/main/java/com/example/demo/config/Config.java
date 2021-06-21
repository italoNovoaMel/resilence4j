//package com.example.demo.config;
//
//import com.example.demo.DemoApplication;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//public class Config {
//
//    private static final Logger log = (Logger) LoggerFactory.getLogger(DemoApplication.class);
//
//
//
//
//
//    public static CommandLineRunner run(String endPoint) throws Exception {
//        RestTemplate restTemplate = new RestTemplate();
//        return args -> {
//            ResponseEntity<Double> rest = restTemplate.getForObject(
//                    "http://localhost:8081/"+endPoint, ResponseEntity.class);
//            log.info(rest.toString());
//        };
//    }
//}
