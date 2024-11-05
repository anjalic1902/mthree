package com.example;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class WeatherValidator {
    public void validateWeatherCondition(WeatherRequestDTO weatherRequestDTO){
        List<String> violations = new ArrayList<>();

        if(weatherRequestDTO.getTemperature() > 30 && "Snowy".equals(weatherRequestDTO.getWeatherCondition())){
            violations.add("Snowy weather is not allowed when temperature is above 30 degrees");
        }

        if(weatherRequestDTO.getTemperature() < 0 && "Sunny".equals(weatherRequestDTO.getWeatherCondition())){
            violations.add("Sunny weather is not allowed when temperature is below 0 degrees");
        }

        if(violations.isEmpty()){
            return;
            }
        throw new WeatherValidationException(String.join(" ",violations),violations);
    }
}