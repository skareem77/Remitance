package com.remitance.country.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remitance.country.model.CountryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    ResourceLoader resourceLoader;

    @Cacheable("country-cache")
    public CountryList getCountry() {
        Resource resource = resourceLoader.getResource("classpath:country.json");
        CountryList list = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(resource.getInputStream(), CountryList.class);
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
        return list;
    }
}
