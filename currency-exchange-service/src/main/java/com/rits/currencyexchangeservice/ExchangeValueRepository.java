package com.rits.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 22/08/18
 */
@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {

    ExchangeValue findByFromAndTo(String from,String to);
}
