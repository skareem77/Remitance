package com.remitance.exchange.service;

import com.remitance.exchange.model.Exchange;
import com.remitance.exchange.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    ExchangeRepository exchangeRepository;

    @Override
    public Double converter(String from, String to, int amount) {
        Exchange exchange = exchangeRepository.exchangeAmount(from, to);
        Map<String, Double> map = (LinkedHashMap)exchange.getRate();
        return map.get(to) * amount;
    }
}
