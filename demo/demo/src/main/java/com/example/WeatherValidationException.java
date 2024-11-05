package com.example;
import java.util.*;

public class WeatherValidationException extends WeatherException{
    private final List<String> violations;
    
    public WeatherValidationException(String message, List<String> violations){
        super(message);
        this.violations = violations.isEmpty()
                ? List.of()
                : List.of(String.join(", ", violations));
    }
    public WeatherValidationException(List<String> violations){
        super("Weather validation failed: " + String.join(" ",violations));
        this.violations = new ArrayList<>(violations);
    }
    
    public List<String> getViolations(){
        return violations;
    }
    
    
    
    }