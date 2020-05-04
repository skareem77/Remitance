package com.remitance.country.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CountryHealth implements HealthIndicator {
    @Override
    public Health health() {
        System.out.println("Country health is up");
        return Health.up().build();
    }
}
