package com.example.Water.dto;

public class PredictionResponse
{
    public double WQI;
    public String quality;

    public double getWQI() {
        return WQI;
    }

    public void setWQI(double WQI) {
        this.WQI = WQI;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}

