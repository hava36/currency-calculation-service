package com.hava.demo.currency_calculation.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rates")
@Getter
@Setter
public class Rate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code")
    private Integer currencyCode;

    @Column(name = "rate")
    private Double rateValue;

    @Column(name = "multiplicity")
    private Double multiplicity;

    public Rate id(Long id) {
        this.id = id;
        return this;
    }

    public Rate currencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public Rate rateValue(Double rate) {
        this.rateValue = rate;
        return this;
    }

    public Rate multiplicity(Double multiplicity) {
        this.multiplicity = multiplicity;
        return this;
    }

}
