package com.remitance.countryCurrency.repository;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.remitance.countryCurrency.model.CountryCurrency;
import com.remitance.countryCurrency.model.CountryList;
import com.remitance.countryCurrency.model.CurrencyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class CountryCurrencyRepoImpl implements CountryCurrencyRepo {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "defaultData")
    public CountryCurrency getCC() {
        CountryCurrency countryCurrency = new CountryCurrency();
        try {
            CurrencyList currencyList = restTemplate.getForObject("http://currency/v1/currencies", CurrencyList.class);
            CountryList countryList = restTemplate.getForObject("http://country/v1/countries", CountryList.class);
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
