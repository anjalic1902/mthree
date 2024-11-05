package com.example;

import jakarta.validation.constraints.*;
public class WeatherRequestDTO {
    @NotBlank(message = "City is required and cannot be empty")
    @Size(min = 3, max = 20, message = "City must be between 3 and 20 characters")
    private String city;

    @Min(value = -50, message = "Temperature cannot be less than -50")
    @Max(value = 50, message = "Temperature cannot be greater than 50")
    private int temperature;

    @NotBlank(message = "Weather condition is required and cannot be empty")
    @Size(min = 3, max = 20, message = "Weather condition must be between 3 and 20 characters")
    @Pattern(regexp = "^(sunny|cloudy|rainy|snowy)$", message = "Weather condition must be sunny, cloudy, rainy, or snowy")
    private String weatherCondition;


    //getters and setters
    public String getCity(){
        return city;
    }   
    public void setCity(String city){
        this.city = city;
    }   
    public int getTemperature(){
        return temperature;
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }   
    public String getWeatherCondition(){
        return weatherCondition;
    }   
    public void setWeatherCondition(String weatherCondition){
        this.weatherCondition = weatherCondition;
    }   
}