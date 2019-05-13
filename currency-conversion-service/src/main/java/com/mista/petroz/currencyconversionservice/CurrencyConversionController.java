package com.mista.petroz.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Currency Calculation Solution
 * Overview Diagram
 * 
 * @startuml
 * title: Ribbon Load Balancing
 * 
 * component ribbon [
 * 		Ribbon
 * 		Load balancer
 * 	]
 * 
 * [CurrencyCalculationService] -down-> [ribbon]
 * [ribbon] -right-> [NamingServer]
 * 
 * [ribbon] --> [CurrencyExchange.1]
 * [ribbon] --> [CurrencyExchange.2]
 * [ribbon] --> [CurrencyExchange.3]
 *
 * @enduml
 */

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping(path="/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConvertionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:6001/currency-exchange/from/{from}/to/{to}", 
				CurrencyConvertionBean.class, uriVariables);
		CurrencyConvertionBean response = responseEntity.getBody();
		
		return new CurrencyConvertionBean(response.getId(),from,to,response.getConvertionMultiple(),
				quantity,
				quantity.multiply(response.getConvertionMultiple()),response.getPort());
		
	}
	
	@GetMapping(path="/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

		CurrencyConvertionBean response = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConvertionBean(response.getId(),from,to,response.getConvertionMultiple(),
				quantity,quantity.multiply(response.getConvertionMultiple()),response.getPort());
		
	}

}
