package com.itbulls.learnit.javacore.oop.solid.d.solution;

import java.util.Arrays;

public class WeatherAggregator {
    private WeatherSource[] weatherSources;
 
    public WeatherAggregator(WeatherSource[] weatherSources) {
        this.weatherSources = weatherSources;
    }
 
    public double getTemperature() {
        return Arrays.stream(weatherSources)
            .mapToDouble(WeatherSource::getTemperatureCelcius)
            .average()
            .getAsDouble();
    }
}
