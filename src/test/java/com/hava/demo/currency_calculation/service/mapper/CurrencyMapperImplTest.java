package com.hava.demo.currency_calculation.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.hava.demo.currency_calculation.entity.Currency;
import com.hava.demo.currency_calculation.entity.Rate;
import com.hava.demo.currency_calculation.model.CurrencyItem;
import com.hava.demo.currency_calculation.model.RateItem;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrencyMapperImplTest {

    @InjectMocks
    CurrencyMapperImpl currencyMapper;

    @Mock
    RateMapper rateMapper;

    @Test
    void toDto_MapFields_FieldsHaveBeenMappedSuccessfully() {

        when(rateMapper.toDto(any())).thenReturn(new RateItem());

        Currency entity = new Currency().code(1).alpha3("EUR").description("description").rates(Collections.singletonList(new Rate()));
        CurrencyItem dto = currencyMapper.toDto(entity);
        assertEquals(1, dto.getCode());
        assertEquals("EUR", dto.getAlpha3());
        assertEquals("description", dto.getDescription());
        assertEquals(1, dto.getRates().size());

    }

    @Test
    void toEntity_MapFields_FieldsHaveBeenMappedSuccessfully() {

        when(rateMapper.toEntity(any())).thenReturn(new Rate());

        CurrencyItem dto = new CurrencyItem().code(1).alpha3("EUR").description("description").rates(Collections.singletonList(new RateItem()));
        Currency entity = currencyMapper.toEntity(dto);
        assertEquals(1, entity.getCode());
        assertEquals("EUR", entity.getAlpha3());
        assertEquals("description", entity.getDescription());
        assertEquals(1, entity.getRates().size());

    }
}