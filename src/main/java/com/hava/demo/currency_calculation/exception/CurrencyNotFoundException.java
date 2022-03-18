package com.hava.demo.currency_calculation.exception;

public class CurrencyNotFoundException extends RuntimeException {

    public CurrencyNotFoundException(Integer currencyCode) {
        super(String.format("Currency not found with code %s", currencyCode));
    }
}
