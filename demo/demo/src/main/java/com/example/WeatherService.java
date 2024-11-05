// WeatherService.java
package com.example;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service  // Singleton by default
public class WeatherService {
    private Map<String, WeatherRecord> weatherData = new HashMap<>();
    private int totalRequests = 0;  // Shared counter for all users

    public void updateWeather(String city, double temperature, String condition) {
        weatherData.put(city, new WeatherRecord(city, temperature, condition));
        totalRequests++;
    }

    public WeatherRecord getWeather(String city) {
        totalRequests++;
        return weatherData.get(city);
    }

    public int getTotalRequests() {
        return totalRequests;
    }
}