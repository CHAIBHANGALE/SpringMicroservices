package com.example.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private org.springframework.core.env.Environment Environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		
		exchangeValue.setPort(Integer.parseInt(Environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
