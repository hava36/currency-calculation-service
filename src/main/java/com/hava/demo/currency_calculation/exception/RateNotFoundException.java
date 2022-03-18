package com.hava.demo.currency_calculation.exception;

public class RateNotFoundException extends RuntimeException {

    public RateNotFoundException(Integer currencyCode) {
        super(String.format("Rate not found for currency code %s", currencyCode));
    }
}
