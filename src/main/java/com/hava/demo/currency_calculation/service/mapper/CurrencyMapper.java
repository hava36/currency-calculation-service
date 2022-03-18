package com.hava.demo.currency_calculation.service.mapper;

import com.hava.demo.currency_calculation.entity.Currency;
import com.hava.demo.currency_calculation.model.CurrencyItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RateMapper.class})
public interface CurrencyMapper {

    CurrencyItem toDto(Currency currency);

    Currency toEntity(CurrencyItem currencyDto);

}
