package com.hava.demo.currency_calculation.service;

import java.math.BigDecimal;

public interface CurrencyConversionService<T> {

    T convert(Integer currencyCodeFrom, Integer currencyCodeTo, BigDecimal amount);

}
