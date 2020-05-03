package com.remitance.exchange.service;

import com.remitance.exchange.model.CountryCurrency;
import com.remitance.exchange.repository.CountryCurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryCurrencyServiceImpl implements CountryCurrencyService {

    @Autowired
    CountryCurrencyRepo countryCurrencyRepo;

    public CountryCurrency getCCService() {
        return countryCurrencyRepo.getCC();
    }

}
