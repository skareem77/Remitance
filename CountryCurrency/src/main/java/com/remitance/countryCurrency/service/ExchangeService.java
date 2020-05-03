package com.remitance.countryCurrency.service;

public interface ExchangeService {
    Double converter(String from, String to, int amount);
}
