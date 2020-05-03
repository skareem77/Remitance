package com.remittance.currency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CurrencyList {

    @JsonProperty("currency")
    List<Currencies> currencies;

    public CurrencyList() {
        currencies = new ArrayList<>();
    }

    public List<Currencies> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currencies> currencies) {
        this.currencies = currencies;
    }
}
