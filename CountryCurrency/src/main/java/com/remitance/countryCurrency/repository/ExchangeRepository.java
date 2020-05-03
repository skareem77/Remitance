package com.remitance.countryCurrency.repository;

import com.remitance.countryCurrency.model.Exchange;

public interface ExchangeRepository {
    Exchange exchangeAmount(String from, String to, int amount);
}
