package com.remitance.exchange.repository;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.remitance.exchange.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class ExchangeRepositoryImpl implements ExchangeRepository {

    @Autowired
    RestTemplate exchangeRestTemplate;

    @Override
    //@HystrixCommand(fallbackMethod = "defaultExchange")
    public Exchange exchangeAmount(String from, String to) {
        StringBuilder sb = new StringBuilder("https://api.exchangeratesapi.io/latest");
        sb.append("?base=" + from).append("&symbols=" +to);
        Exchange response = exchangeRestTemplate.getForObject(sb.toString(), Exchange.class);
        return response;
    }

    public Exchange defaultExchange() {
        Exchange exchange = new Exchange();
        Map<String, Double> map = new LinkedHashMap<>();
        exchange.setRate(map);
        return exchange;
    }
}
