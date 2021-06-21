package com.example.division.service;

import org.springframework.stereotype.Service;

@Service
public class OperationService implements IOperationService {

    @Override
    public double returnRandomProbability() {
        return Math.random();
    }

}
