package com.hava.demo.currency_calculation.service.mapper;

import com.hava.demo.currency_calculation.entity.Rate;
import com.hava.demo.currency_calculation.model.RateItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateMapper {

    RateItem toDto(Rate currency);

    Rate toEntity(RateItem currencyDto);

}
