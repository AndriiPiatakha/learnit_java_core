package com.itbulls.learnit.javacore.oop.solid.d.problem;

public class WeatherAggregator {
    private AccuweatherApi accuweather = new AccuweatherApi();
    private BbcWeatherApi bbcWeather = new BbcWeatherApi();
 
    public double getTemperature() {
        return (accuweather.getTemperatureCelcius() 
        		+ toCelcius(
        				bbcWeather.getTemperatureFahrenheit())) / 2;
    }
 
    private double toCelcius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8f;
    }
}
