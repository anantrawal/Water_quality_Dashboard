package com.example.Water.controller;

import com.example.Water.dto.PredictionRequest;
import com.example.Water.dto.PredictionResponse;
import com.example.Water.service.MlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PredictionController {

    private final MlService mlService;

    public PredictionController(MlService mlService) {
        this.mlService = mlService;
    }

    @PostMapping("/predict")
    public PredictionResponse predict() {

        PredictionRequest req = new PredictionRequest();
        req.temperature = 26;
        req.turbidity = 5;
        req.ph = 7.2;
        req.doValue = 6.8;
        req.bod = 3.1;
        req.cod = 18;
        req.nitrate = 2.4;
        req.phosphate = 0.5;
        req.tds = 320;
        req.conductivity = 480;
        req.fecal_coliform = 45;

        return mlService.predict(req);
    }
}
