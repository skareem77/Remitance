package com.remittance.currency.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  "XCD": {
 *             "currencyName": "East Caribbean Dollar",
 *             "currencySymbol": "$",
 *             "id": "XCD"
 *         },
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currencies {

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol")
    private String symbol;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
