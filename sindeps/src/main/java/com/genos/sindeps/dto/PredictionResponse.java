package com.genos.sindeps.dto;

public class PredictionResponse {
    private String message;
    private double predictedSales;
    private long productId;

    public PredictionResponse(String message, double predictedSales, long productId) {
        this.message = message;
        this.predictedSales = predictedSales;
        this.productId = productId;
    }

    public String getMessage() {
        return message;
    }

    public double getPredictedSales() {
        return predictedSales;
    }

    public long getProductId() {
        return productId;
    }
}
