package com.remitance.countryCurrency.webResource;

import com.remitance.countryCurrency.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeResource {

    @Autowired
    ExchangeService exchangeService;

    @RequestMapping(value = "/v1/convert", method = RequestMethod.GET)
    public String getExchange(@RequestParam("from") String from, @RequestParam ("to") String to, @RequestParam("amount") int amount) {
        Double value = exchangeService.converter(from, to, amount);
        return "The amount is " + value;
    }
}
