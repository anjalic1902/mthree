package com.example;

public class WeatherValidationConstants {
    public static final int MIN_TEMPERATURE = -50;
    public static final int MAX_TEMPERATURE = 50;

    public static final String WEATHER_CONDITION_PATTERN = "^(sunny|cloudy|rainy|snowy)$";
    public static final int CITY_MIN_LENGTH = 3;
    public static final int CITY_MAX_LENGTH = 20;

    public static final String CITY_BLANK_MESSAGE = "City is required and cannot be empty";         
    public static final String CITY_SIZE_MESSAGE = "City must be between 3 and 20 characters";
    public static final String CITY_PATTERN_MESSAGE = "City must be sunny, cloudy, rainy, or snowy";

    public static final String TEMPERATURE_MIN_MESSAGE = "Temperature cannot be less than -50";
    public static final String TEMPERATURE_MAX_MESSAGE = "Temperature cannot be greater than 50";

    public static final String WEATHER_CONDITION_BLANK_MESSAGE = "Weather condition is required and cannot be empty";
    public static final String WEATHER_CONDITION_SIZE_MESSAGE = "Weather condition must be between 3 and 20 characters";
    public static final String WEATHER_CONDITION_PATTERN_MESSAGE = "Weather condition must be sunny, cloudy, rainy, or snowy";
}