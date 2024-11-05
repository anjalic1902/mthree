// WeatherController.java
package com.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;
import java.util.HashMap;
import java.util.Map;
import com.example.UserWeatherPreferences;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;              // Singleton
    private final WeatherRequestLogger requestLogger;         // Request Scope
    private final UserWeatherPreferences userPreferences;     // Session Scope
    private final ApplicationContext applicationContext;      // For Prototype

    public WeatherController(
            WeatherService weatherService,
            WeatherRequestLogger requestLogger,
            UserWeatherPreferences userPreferences,
            ApplicationContext applicationContext) {
        this.weatherService = weatherService;
        this.requestLogger = requestLogger;
        this.userPreferences = userPreferences;
        this.applicationContext = applicationContext;
    }

    @GetMapping("/{city}")
    public Map<String, Object> getWeather(@PathVariable String city) {
        // Request scope - log the request
        requestLogger.logRequest(city);

        // Session scope - add to recent searches
        userPreferences.addSearch(city);

        // Prototype scope - create new query
        WeatherQuery query = applicationContext.getBean(WeatherQuery.class);

        // Singleton - get weather data
        WeatherRecord weather = weatherService.getWeather(city);

        Map<String, Object> response = new HashMap<>();
        response.put("weather", weather);
        response.put("requestInfo", requestLogger.getRequestInfo());
        response.put("recentSearches", userPreferences.getRecentSearches());
        response.put("queryInfo", Map.of(
            "queryId", query.getQueryId(),
            "queryTime", query.getQueryTime()
        ));
        response.put("totalRequests", weatherService.getTotalRequests());

        return response;
    }

    @PostMapping("/{city}")
    public Map<String, Object> updateWeather(
            @PathVariable String city,
            @RequestParam double temperature,
            @RequestParam String condition) {
        weatherService.updateWeather(city, temperature, condition);
        return getWeather(city);
    }

    @PostMapping("/preferences/unit")
    public Map<String, String> setUnit(@RequestParam String unit) {
        userPreferences.setTemperatureUnit(unit);
        return Map.of(
            "sessionId", userPreferences.getSessionId(),
            "unit", userPreferences.getTemperatureUnit()
        );
    }
}
