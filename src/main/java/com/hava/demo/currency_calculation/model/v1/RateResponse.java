package com.hava.demo.currency_calculation.model.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-18T16:16:53.505784700+03:00[Europe/Moscow]")
public class RateResponse {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("currencyCode")
    private Integer currencyCode;

    @JsonProperty("rate")
    private BigDecimal rate;

    @JsonProperty("multiplicity")
    private BigDecimal multiplicity;

    public RateResponse id(Integer id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(value = "")

    @Min(1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RateResponse currencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    @ApiModelProperty(value = "")

    @Min(2)
    @Max(3)
    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public RateResponse rate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public RateResponse multiplicity(BigDecimal multiplicity) {
        this.multiplicity = multiplicity;
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid

    public BigDecimal getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(BigDecimal multiplicity) {
        this.multiplicity = multiplicity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RateResponse rateResponse = (RateResponse) o;
        return Objects.equals(this.id, rateResponse.id)
            && Objects.equals(this.currencyCode, rateResponse.currencyCode)
            && Objects.equals(this.rate, rateResponse.rate)
            && Objects.equals(this.multiplicity, rateResponse.multiplicity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyCode, rate, multiplicity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RateResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
        sb.append("    multiplicity: ").append(toIndentedString(multiplicity)).append("\n");
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

