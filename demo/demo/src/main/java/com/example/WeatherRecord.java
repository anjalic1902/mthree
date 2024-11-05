// WeatherRecord.java
package com.example;

public class WeatherRecord {
    private String city;
    private double temperature;
    private String condition;

    public WeatherRecord(String city, double temperature, String condition) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
    }

    // Getters and Setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
}