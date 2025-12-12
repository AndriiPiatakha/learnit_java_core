package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example2;

public class MoneyRoundingService {

    public double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
