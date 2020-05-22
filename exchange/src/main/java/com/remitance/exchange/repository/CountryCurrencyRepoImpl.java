package com.remitance.exchange.repository;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.remitance.exchange.model.CountryCurrency;
import com.remitance.exchange.model.CountryList;
import com.remitance.exchange.model.CurrencyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class CountryCurrencyRepoImpl implements CountryCurrencyRepo {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Cacheable("country-currency-cache")
    //@HystrixCommand
    //@HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    public CountryCurrency getCC() {
        CountryCurrency countryCurrency = new CountryCurrency();
        try {
            CountryList countryList = restTemplate.getForObject("http://country-service/v1/countries", CountryList.class);
            CurrencyList currencyList = restTemplate.getForObject("http://currency-service/v1/currencies", CurrencyList.class);
            countryCurrency.setCountryList(countryList);
            countryCurrency.setCurrencyList(currencyList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return countryCurrency;
    }

    public CountryCurrency defaultData() {
        CountryCurrency countryCurrency = new CountryCurrency();
        CurrencyList currencyList = new CurrencyList();
        CountryList countryList = new CountryList();
        currencyList.setCurrencies(new ArrayList<>());
        countryList.setCountry(new ArrayList<>());
        countryCurrency.setCountryList(countryList);
        countryCurrency.setCurrencyList(currencyList);

        return countryCurrency;
    }
}
