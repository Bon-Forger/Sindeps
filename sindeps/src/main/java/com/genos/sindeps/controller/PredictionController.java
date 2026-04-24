package com.genos.sindeps.controller;

import com.genos.sindeps.dto.PredictionResponse;
import com.genos.sindeps.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping("/predict/{productId}")
    public PredictionResponse predict(@PathVariable long productId) {
        return predictionService.predictDemand(productId);
    }
}
