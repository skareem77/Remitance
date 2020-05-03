package com.remittance.currency.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        System.out.println("System is up");
        return Health.up().build();
    }
}
