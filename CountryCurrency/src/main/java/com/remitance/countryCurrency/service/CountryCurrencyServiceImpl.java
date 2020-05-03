package com.remitance.countryCurrency.service;

import com.remitance.countryCurrency.model.CountryCurrency;
import com.remitance.countryCurrency.repository.CountryCurrencyRepo;
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
