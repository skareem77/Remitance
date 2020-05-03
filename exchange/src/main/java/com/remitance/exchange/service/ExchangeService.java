package com.remitance.exchange.service;

public interface ExchangeService {
    Double converter(String from, String to, int amount);
}
