// WeatherQuery.java
package com.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class WeatherQuery {
    private final String queryId = java.util.UUID.randomUUID().toString();
    private final LocalDateTime queryTime = LocalDateTime.now();

    public String getQueryId() { return queryId; }
    public LocalDateTime getQueryTime() { return queryTime; }
}