package com.remitance.exchange.model;

public class CountryCurrency {

    private CurrencyList currencyList;
    private CountryList countryList;

    public CurrencyList getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(CurrencyList currencyList) {
        this.currencyList = currencyList;
    }

    public CountryList getCountryList() {
        return countryList;
    }

    public void setCountryList(CountryList countryList) {
        this.countryList = countryList;
    }
}
