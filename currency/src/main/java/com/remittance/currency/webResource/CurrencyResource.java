package com.remittance.currency.webResource;

import com.remittance.currency.model.CurrencyList;
import com.remittance.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyResource {

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(path = "/v1/currencies", method = RequestMethod.GET)
    public CurrencyList getCurrency() {
        return currencyService.getCurrency();
    }
}
