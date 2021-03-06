package com.remittance.currency.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        System.out.println("Currency service is up");
        return Health.up().status("Currency service is up").build();
    }
}
