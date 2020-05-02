package com.remitance.country.webResource;

import com.remitance.country.model.CountryList;
import com.remitance.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryResource {

    @Autowired
    private CountryService countryService;

    @RequestMapping(path = "/v1/countries", method = RequestMethod.GET)
    public CountryList getCountries() {
        return countryService.getCountry();
    }
}
