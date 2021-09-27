package com.bitlo.repository;

import com.bitlo.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {

    Currency getByCurrencyCode(@Param("currencyCode") String currencyCode);

}
