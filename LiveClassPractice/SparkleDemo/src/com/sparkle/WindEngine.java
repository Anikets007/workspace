package com.sparkle;

public class WindEngine {

    private double wind = 0;
    private double targetWind = 0;
    private int timer = 0;

    private static final double WIND_MIN = -1.5;
    private static final double WIND_MAX = 1.5;

    public void updateWind() {
        if (timer <= 0) {
            targetWind = WIND_MIN + Math.random() * (WIND_MAX - WIND_MIN);
            timer = 40 + (int)(Math.random() * 80);
        }

        wind += (targetWind - wind) * 0.02;
        timer--;
    }

    public double getWind() {
        return wind;
    }
}

