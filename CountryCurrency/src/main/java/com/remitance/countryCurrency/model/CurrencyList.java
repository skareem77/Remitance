package com.remitance.countryCurrency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CurrencyList {

    @JsonProperty("currency")
    List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
