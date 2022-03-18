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
    private Integer id;

    @Column(name = "currency_code")
    private Integer currencyCode;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "multiplicity")
    private Float multiplicity;

}
