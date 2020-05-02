package com.remitance.country.service;

import com.remitance.country.model.CountryList;
import com.remitance.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryList getCountry() {
        return countryRepository.getCountry();
    }
}
