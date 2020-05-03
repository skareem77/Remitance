package com.remittance.currency.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remittance.currency.model.CurrencyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;

@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public CurrencyList getCurrency() {
        Resource resource = resourceLoader.getResource("classpath:Currencies.json");
        CurrencyList list = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(resource.getInputStream(), CurrencyList.class);
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
        return list;
    }
}
