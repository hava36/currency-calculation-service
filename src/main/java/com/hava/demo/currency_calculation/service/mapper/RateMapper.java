package com.hava.demo.currency_calculation.service.mapper;

import com.hava.demo.currency_calculation.entity.Rate;
import com.hava.demo.currency_calculation.model.v1.RateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateMapper {

    RateResponse toDto(Rate currency);

    Rate toEntity(RateResponse currencyDto);

}
