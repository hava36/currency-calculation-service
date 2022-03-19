package com.hava.demo.currency_calculation.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hava.demo.currency_calculation.entity.Rate;
import com.hava.demo.currency_calculation.model.RateItem;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RateMapperImplTest {

    @InjectMocks
    RateMapperImpl rateMapper;

    @Test
    void toDto_MapFields_FieldsHaveBeenMappedSuccessfully() {

        Rate entity = new Rate().rateValue(1d).currencyCode(643).id(1l).multiplicity(1d);
        RateItem dto = rateMapper.toDto(entity);
        assertEquals(1, dto.getId());
        assertEquals(1d, dto.getRateValue().doubleValue());
        assertEquals(643, dto.getCurrencyCode().doubleValue());
        assertEquals(1d, dto.getMultiplicity().doubleValue());

    }

    @Test
    void toEntity_MapFields_FieldsHaveBeenMappedSuccessfully() {

        RateItem dto = new RateItem().rateValue(new BigDecimal(1)).currencyCode(643).id(1).multiplicity(new BigDecimal(1));
        Rate entity = rateMapper.toEntity(dto);
        assertEquals(1, entity.getId());
        assertEquals(1d, entity.getRateValue());
        assertEquals(643, entity.getCurrencyCode());
        assertEquals(1d, entity.getMultiplicity());

    }

}