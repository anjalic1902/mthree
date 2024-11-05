package com.example;

import java.util.*;

public class WeatherException extends RuntimeException{
    public WeatherException(String message){
        super(message);
    }
    public WeatherException(String message, Throwable cause){
        super(message, cause);
    }
}