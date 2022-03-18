package com.hava.demo.currency_calculation.controller.v1.advice;

import com.hava.demo.currency_calculation.controller.v1.CurrencyConversionController;
import com.hava.demo.currency_calculation.exception.CurrencyNotFoundException;
import com.hava.demo.currency_calculation.exception.RateNotFoundException;
import com.hava.demo.currency_calculation.model.ConversionFailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = CurrencyConversionController.class)
public class CurrencyConversionAdviceController {

    @ExceptionHandler({CurrencyNotFoundException.class, RateNotFoundException.class})
    public ResponseEntity<ConversionFailResponse> entityNotFoundException(Exception exception) {
        return ResponseEntity.internalServerError().body(new ConversionFailResponse().errorDescription(exception.getMessage()));
    }

}