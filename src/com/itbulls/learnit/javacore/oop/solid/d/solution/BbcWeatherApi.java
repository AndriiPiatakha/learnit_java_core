package com.itbulls.learnit.javacore.oop.solid.d.solution;

public class BbcWeatherApi implements WeatherSource {
    @Override
    public double getTemperatureCelcius() {
        return toCelcius(getTemperatureFahrenheit());
    }
 
    private double getTemperatureFahrenheit() {
		return 0; // stub method for the sake of the demo
    }
 
    private double toCelcius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8f;
    }
}
