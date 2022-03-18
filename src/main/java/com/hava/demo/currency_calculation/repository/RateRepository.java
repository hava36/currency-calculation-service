package com.hava.demo.currency_calculation.repository;

import com.hava.demo.currency_calculation.entity.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate, Integer> {

}
