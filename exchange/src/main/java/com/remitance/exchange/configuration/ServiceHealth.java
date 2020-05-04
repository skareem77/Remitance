package com.remitance.exchange.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealth implements HealthIndicator {
    @Override
    public Health health() {
        System.out.println("Exchange health is up");
        return Health.up().status(Status.UP).build();
    }
}
