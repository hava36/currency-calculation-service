package com.hava.demo.currency_calculation.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "currencies")
@Getter
@Setter
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    @Column(name = "description")
    private String description;

    @Column(name = "alpha3")
    private String alpha3;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyCode")
    private List<Rate> rates;

    public Currency code(Integer code) {
        this.code = code;
        return this;
    }

    public Currency description(String description) {
        this.description = description;
        return this;
    }

    public Currency alpha3(String alpha3) {
        this.alpha3 = alpha3;
        return this;
    }

    public Currency rates(List<Rate> rates) {
        this.rates = rates;
        return this;
    }


}
