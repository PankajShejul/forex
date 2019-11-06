package com.innovecture.forex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovecture.forex.model.Forex;
import com.innovecture.forex.repository.ForexRepository;

@Service
public class ForexService {

	@Autowired
	private ForexRepository repository;
	
	public void init(Forex forex)
	{
		repository.save(forex);
	}

	public double convert(String from, String to) {
		String base="USD";
		if(repository.findByToCurrency(from) == null || repository.findByToCurrency(to) == null ) {
			return 0.0;
		}
		
		if (from.equals(base)) {
			Forex currency = repository.findByToCurrency(to);
			return (currency.getExchangeRate());

		} else if (to.equals(base)) {
			Forex currency = repository.findByToCurrency(from);
			return (1 / currency.getExchangeRate());

		} else {
			Forex fromCurrency = repository.findByToCurrency(from);
			Forex toCurrency = repository.findByToCurrency(to);
			double factor = 1 / fromCurrency.getExchangeRate();
			double exchangeFactor = factor * toCurrency.getExchangeRate();
			return (exchangeFactor);
		}
		
	}
}
