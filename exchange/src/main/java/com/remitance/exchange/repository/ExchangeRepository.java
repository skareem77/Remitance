package com.remitance.exchange.repository;

import com.remitance.exchange.model.Exchange;

public interface ExchangeRepository {
    Exchange exchangeAmount(String from, String to);
}
