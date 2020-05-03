package com.remittance.currency.service;

import com.remittance.currency.model.CurrencyList;
import com.remittance.currency.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public CurrencyList getCurrency() {
        return currencyRepository.getCurrency();
    }
}
