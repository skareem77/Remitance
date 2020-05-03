package com.remitance.countryCurrency.webResource;

import com.remitance.countryCurrency.model.CountryCurrency;
import com.remitance.countryCurrency.service.CountryCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryCurrencyResource {

    @Autowired
    CountryCurrencyService countryCurrencyService;

    @RequestMapping(value = "/v1/countryCurrency", method = RequestMethod.GET)
    public CountryCurrency getData() {
        return countryCurrencyService.getCCService();
    }
}
