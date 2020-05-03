package com.remitance.countryCurrency.repository;

import com.remitance.countryCurrency.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ExchangeRepositoryImpl implements ExchangeRepository {

    @Autowired
    RestTemplate exchangeRestTemplate;

    @Override
    public Exchange exchangeAmount(String from, String to, int amount) {
        StringBuilder sb = new StringBuilder("https://api.exchangeratesapi.io/latest");
        sb.append("?base=" + from).append("&symbols=" +to);
        Exchange response = exchangeRestTemplate.getForObject(sb.toString(), Exchange.class);
        return response;
    }
}