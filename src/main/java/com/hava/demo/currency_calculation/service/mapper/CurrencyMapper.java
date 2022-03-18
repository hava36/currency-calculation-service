package com.hava.demo.currency_calculation.service.mapper;

import com.hava.demo.currency_calculation.entity.Currency;
import com.hava.demo.currency_calculation.model.v1.CurrencyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RateMapper.class})
public interface CurrencyMapper {

    CurrencyResponse toDto(Currency currency);

    Currency toEntity(CurrencyResponse currencyDto);

}
