package com.hava.demo.currency_calculation.model.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-18T16:16:53.505784700+03:00[Europe/Moscow]")
public class CurrencyResponse {
    @JsonProperty("code")
    private Integer code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("alpha3")
    private String alpha3;

    @JsonProperty("rates")
    @Valid
    private List<RateResponse> rates = null;

    public CurrencyResponse code(Integer code) {
        this.code = code;
        return this;
    }

    @ApiModelProperty(value = "")

    @Min(2)
    @Max(3)
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CurrencyResponse description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(value = "")

    @Size(max = 40)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CurrencyResponse alpha3(String alpha3) {
        this.alpha3 = alpha3;
        return this;
    }

    @ApiModelProperty(value = "")

    @Size(max = 3)
    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public CurrencyResponse rates(List<RateResponse> rates) {
        this.rates = rates;
        return this;
    }

    public CurrencyResponse addRatesItem(RateResponse ratesItem) {
        if (this.rates == null) {
            this.rates = new ArrayList<>();
        }
        this.rates.add(ratesItem);
        return this;
    }

    @ApiModelProperty(value = "")

    @Valid

    public List<RateResponse> getRates() {
        return rates;
    }

    public void setRates(List<RateResponse> rates) {
        this.rates = rates;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CurrencyResponse currencyResponse = (CurrencyResponse) o;
        return Objects.equals(this.code, currencyResponse.code)
            && Objects.equals(this.description, currencyResponse.description)
            && Objects.equals(this.alpha3, currencyResponse.alpha3)
            && Objects.equals(this.rates, currencyResponse.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description, alpha3, rates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CurrencyResponse {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    alpha3: ").append(toIndentedString(alpha3)).append("\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
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

