package com.mista.petroz.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mista.petroz.currencyexchangeservice.bean.ExchangeValue;
import com.mista.petroz.currencyexchangeservice.bean.ExchangeValueRepository;

/**
 * Currency Calculation Solution
 * Overview Diagram
 * 
 * @startuml
 * title: Currency Calculation Design
 * 
 * [CurrencyCalculationService] as Comp1
 * [CurrencyExchangeService] as Comp2 
 * [LimitsService] as Comp3 
 * 
 * database "Database" {
 * }
 * database "Configuration" { 
 * }
 * [Comp1] -right-> [Comp2] 
 * [Comp2] -right-> [Comp3] 
 * [Comp2] --> Configuration
 * [Comp3] --> Database
 *
 * @enduml
 */

@RestController	
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return exchangeValue;
	}

}
