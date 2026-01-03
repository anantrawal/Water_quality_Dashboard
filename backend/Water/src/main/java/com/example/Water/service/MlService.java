package com.example.Water.service;

import com.example.Water.dto.PredictionRequest;
import com.example.Water.dto.PredictionResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MlService {

    private final RestTemplate restTemplate = new RestTemplate();

    public PredictionResponse predict(PredictionRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PredictionRequest> entity =
                new HttpEntity<>(request, headers);

        return restTemplate.postForObject(
                "http://localhost:5000/predict",
                entity,
                PredictionResponse.class
        );
    }
}
