package com.hava.demo.currency_calculation.model.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-18T16:16:53.505784700+03:00[Europe/Moscow]")
public class CurrencyConversionResponse {
    @JsonProperty("currencyFrom")
    private CurrencyResponse currencyFrom;

    @JsonProperty("currencyTo")
    private CurrencyResponse currencyTo;

    @JsonProperty("margin")
    private BigDecimal margin;

    @JsonProperty("currencyAmount")
    private BigDecimal currencyAmount;

    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;

    public CurrencyConversionResponse currencyFrom(CurrencyResponse currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid

    public CurrencyResponse getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(CurrencyResponse currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public CurrencyConversionResponse currencyTo(CurrencyResponse currencyTo) {
        this.currencyTo = currencyTo;
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid

    public CurrencyResponse getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(CurrencyResponse currencyTo) {
        this.currencyTo = currencyTo;
    }

    public CurrencyConversionResponse margin(BigDecimal margin) {
        this.margin = margin;
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid
    @DecimalMin("0")
    @DecimalMax("1")
    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public CurrencyConversionResponse currencyAmount(BigDecimal currencyAmount) {
        this.currencyAmount = currencyAmount;
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid
    @DecimalMin("0")
    public BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(BigDecimal currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public CurrencyConversionResponse totalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid
    @DecimalMin("0")
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CurrencyConversionResponse currencyConversionResponse = (CurrencyConversionResponse) o;
        return Objects.equals(this.currencyFrom, currencyConversionResponse.currencyFrom)
            && Objects.equals(this.currencyTo, currencyConversionResponse.currencyTo)
            && Objects.equals(this.margin, currencyConversionResponse.margin)
            && Objects.equals(this.currencyAmount, currencyConversionResponse.currencyAmount)
            && Objects.equals(this.totalAmount, currencyConversionResponse.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyFrom, currencyTo, margin, currencyAmount, totalAmount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CurrencyConversionResponse {\n");

        sb.append("    currencyFrom: ").append(toIndentedString(currencyFrom)).append("\n");
        sb.append("    currencyTo: ").append(toIndentedString(currencyTo)).append("\n");
        sb.append("    margin: ").append(toIndentedString(margin)).append("\n");
        sb.append("    currencyAmount: ").append(toIndentedString(currencyAmount)).append("\n");
        sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

