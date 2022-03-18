package com.hava.demo.currency_calculation.controller.v1;

import com.hava.demo.currency_calculation.model.ConversionSuccessResponse;
import com.hava.demo.currency_calculation.service.CurrencyConversionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-18T16:16:53.505784700+03:00[Europe/Moscow]")
@Validated
@Api(value = "currency", description = "the currency API")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService<ConversionSuccessResponse> conversionService;

    @ApiOperation(value = "convert currency from one to another",
        nickname = "convertCurrency",
        notes = "convert currency from one to another",
        response = ConversionSuccessResponse.class, tags = {"users"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "currency has been converted successfully", response = ConversionSuccessResponse.class),
        @ApiResponse(code = 500, message = "internal server error"),
        @ApiResponse(code = 503, message = "server is unavailable")})
    @GetMapping(
        value = "api/v1/currency/conversion",
        produces = {"application/json"}
    )
    public ResponseEntity<ConversionSuccessResponse> convertCurrency(
        @Min(2) @Max(3) @ApiParam(value = "source currency") @Valid @RequestParam(value = "currencyCodeFrom", required = false) Integer currencyCodeFrom,
        @Min(2) @Max(3) @ApiParam(value = "destination currency") @Valid @RequestParam(value = "currencyCodeTo", required = false) Integer currencyCodeTo,
        @DecimalMin("0") @ApiParam(value = "destination currency") @Valid @RequestParam(value = "currencyAmount", required = false) BigDecimal amount) {

        return ResponseEntity.ok(conversionService.convert(currencyCodeFrom, currencyCodeTo, amount));

    }

}
