package com.hava.demo.currency_calculation.service;

import com.hava.demo.currency_calculation.controller.ConversionApiDelegate;
import com.hava.demo.currency_calculation.entity.Currency;
import com.hava.demo.currency_calculation.entity.Rate;
import com.hava.demo.currency_calculation.exception.CurrencyNotFoundException;
import com.hava.demo.currency_calculation.exception.RateNotFoundException;
import com.hava.demo.currency_calculation.model.ConversionSuccessResponse;
import com.hava.demo.currency_calculation.repository.CurrencyRepository;
import com.hava.demo.currency_calculation.service.mapper.CurrencyMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ConversionApiDelegate {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;
    private final BigDecimal margin;

    public CurrencyConversionService(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper,
                                     @Value("${application.conversion.currency.margin}") BigDecimal margin) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
        this.margin = margin;
    }


    @Override
    public ResponseEntity<ConversionSuccessResponse> convert(Integer currencyCodeFrom, Integer currencyCodeTo, BigDecimal amount) {

        Map<Integer, Currency> currencies = currencyRepository.findByCodeIn(List.of(currencyCodeFrom, currencyCodeTo))
            .stream().collect(Collectors.toMap(Currency::getCode, Function.identity()));

        Currency currencyTo = checkAndGetCurrencyIfExists(currencyCodeTo, currencies);
        Currency currencyFrom = checkAndGetCurrencyIfExists(currencyCodeFrom, currencies);
        BigDecimal convertedAmount = calculateCurrencyAmount(currencyFrom, currencyTo, amount);
        BigDecimal totalAmount = calculateTotalAmount(convertedAmount);

        ConversionSuccessResponse result = new ConversionSuccessResponse()
            .currencyFrom(currencyMapper.toDto(currencyFrom))
            .currencyTo(currencyMapper.toDto(currencyTo))
            .currencyAmount(convertedAmount)
            .margin(margin)
            .totalAmount(totalAmount);

        return ResponseEntity.ok(result);

    }

    private Currency checkAndGetCurrencyIfExists(Integer currencyCode, Map<Integer, Currency> currencies) {
        if (!currencies.containsKey(currencyCode)) {
            throw new CurrencyNotFoundException(currencyCode);
        }
        Currency currency = currencies.get(currencyCode);
        if (currency.getRates().isEmpty()) {
            throw new RateNotFoundException(currencyCode);
        }
        return currency;
    }

    private BigDecimal calculateCurrencyAmount(Currency currencyFrom, Currency currencyTo, BigDecimal amount) {
        Rate rateFrom = getActualRate(currencyFrom);
        Rate rateTo = getActualRate(currencyTo);
        double currencyAmount = amount.doubleValue() * rateFrom.getMultiplicity() * rateTo.getRateValue() / rateFrom.getRateValue() * rateTo.getMultiplicity();
        return BigDecimal.valueOf(currencyAmount).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalAmount(BigDecimal convertedAmount) {
        return convertedAmount.multiply(BigDecimal.valueOf(1 + margin.doubleValue())).setScale(2, RoundingMode.HALF_UP);
    }

    private Rate getActualRate(Currency currency) {
        return currency.getRates().get(currency.getRates().size() - 1);
    }

}
