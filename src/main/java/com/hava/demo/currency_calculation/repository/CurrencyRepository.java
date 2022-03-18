package com.hava.demo.currency_calculation.repository;

import com.hava.demo.currency_calculation.entity.Currency;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    @EntityGraph(attributePaths = "rates")
    List<Currency> findByCodeIn(List<Integer> codes);

}
