package com.example.Water.service;

import com.example.Water.dto.PredictionRequest;
import com.example.Water.dto.PredictionResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MlService {

    private final RestTemplate restTemplate = new RestTemplate();

    public PredictionResponse predict(PredictionRequest request) {
        return restTemplate.postForObject(
                "http://localhost:5000/predict",
                request,
                PredictionResponse.class
        );
    }
}
