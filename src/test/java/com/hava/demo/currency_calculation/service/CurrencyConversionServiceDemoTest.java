package com.hava.demo.currency_calculation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.hava.demo.currency_calculation.entity.Currency;
import com.hava.demo.currency_calculation.entity.Rate;
import com.hava.demo.currency_calculation.exception.CurrencyNotFoundException;
import com.hava.demo.currency_calculation.exception.RateNotFoundException;
import com.hava.demo.currency_calculation.model.ConversionSuccessResponse;
import com.hava.demo.currency_calculation.model.CurrencyItem;
import com.hava.demo.currency_calculation.repository.CurrencyRepository;
import com.hava.demo.currency_calculation.service.mapper.CurrencyMapper;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CurrencyConversionServiceDemoTest {

    CurrencyConversionService conversionService;

    @Mock
    CurrencyRepository currencyRepository;

    @Mock
    CurrencyMapper currencyMapper;

    @BeforeEach
    void init() {
        this.conversionService = new CurrencyConversionService(currencyRepository, currencyMapper, BigDecimal.valueOf(0.02));
    }

    @Test
    void convert_whenValidCurrencyListWasReceived_ConversionCompletedSuccessfully() {

        Rate euroRate = new Rate().id(1L).rateValue(1d).multiplicity(1d).currencyCode(826);
        Currency euroCurrency = new Currency().code(826).alpha3("EUR").description("EURO").rates(Collections.singletonList(euroRate));

        Rate poundRate = new Rate().id(1L).rateValue(1.23d).multiplicity(1d).currencyCode(978);
        Currency poundCurrency = new Currency().code(978).alpha3("GBP").description("Pound").rates(Collections.singletonList(poundRate));

        when(currencyRepository.findByCodeIn(List.of(826, 978))).thenReturn(List.of(euroCurrency, poundCurrency));
        when(currencyMapper.toDto(any())).thenReturn(new CurrencyItem());

        ResponseEntity<ConversionSuccessResponse> responseEntity = conversionService.convert(826, 978, BigDecimal.valueOf(100L));
        ConversionSuccessResponse result = responseEntity.getBody();

        assertEquals(new BigDecimal("0.02").setScale(2), result.getMargin());
        assertEquals(new BigDecimal("123.00").setScale(2), result.getCurrencyAmount());
        assertEquals(new BigDecimal("125.46").setScale(2), result.getTotalAmount());
        assertNotNull(result.getCurrencyTo());
        assertNotNull(result.getCurrencyFrom());

    }

    @Test
    void convert_whenEuroCurrencyNotExist_CurrencyNotFoundExceptionHasBeenThrown() {

        Rate poundRate = new Rate().id(1L).rateValue(1.23d).multiplicity(1d).currencyCode(978);
        Currency poundCurrency = new Currency().code(978).alpha3("GBP").description("Pound").rates(Collections.singletonList(poundRate));
        when(currencyRepository.findByCodeIn(List.of(826, 978))).thenReturn(List.of(poundCurrency));

        assertThrows(CurrencyNotFoundException.class, () -> conversionService.convert(826, 978, BigDecimal.valueOf(100L)));

    }

    @Test
    void convert_whenPoundCurrencyWithoutRateWasReceived_RateNotFoundExceptionHasBeenThrown() {

        Rate euroRate = new Rate().id(1L).rateValue(1d).multiplicity(1d).currencyCode(826);
        Currency euroCurrency = new Currency().code(826).alpha3("EUR").description("EURO").rates(Collections.singletonList(euroRate));
        Currency poundCurrency = new Currency().code(978).alpha3("GBP").description("Pound").rates(Collections.emptyList());

        when(currencyRepository.findByCodeIn(List.of(826, 978))).thenReturn(List.of(euroCurrency, poundCurrency));

        assertThrows(RateNotFoundException.class, () -> conversionService.convert(826, 978, BigDecimal.valueOf(100L)));

    }

}