package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HelloWorldApplication.class);
        System.out.println("Hello World from main class");
        app.setAdditionalProfiles(args.length > 0 ? args[0] : "default");
        app.run(args);
    }
}
