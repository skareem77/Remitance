package com.remitance.countryCurrency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CountryList {

    @JsonProperty("countries")
    List<Country> country;

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }
}
