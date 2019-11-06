package com.innovecture.forex.controller;

import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.innovecture.forex.model.Forex;
import com.innovecture.forex.service.ForexService;
import com.innovecture.forex.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
public class ForexController {

	@Autowired
	private ForexService forexService;

	@PostConstruct
	public void init() {
		System.out.println("In Controller INIT");
		URI uri = UriComponentsBuilder.fromUriString("https://api.exchangerate-api.com/v4/latest/USD").build().toUri();
		RestTemplate rest = new RestTemplate();
		String entity = rest.getForObject(uri, String.class);
		JSONParser parser = new JSONParser();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Long tLU=1572999099L;

		try {
			JSONObject js = (JSONObject) parser.parse(entity);
			String base = js.get("base").toString();

			date = formatter.parse(js.get("date").toString());

			Long timeLastUpdated = Long.parseLong(js.get("time_last_updated").toString());

			JSONObject rates = (JSONObject) js.get("rates");
			Set<String> set = rates.keySet();
			for (String s : set) {
				String value = rates.get(s).toString();
				Forex forex = new Forex(base, date, timeLastUpdated, s, Double.parseDouble(value));
				forexService.init(forex);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Date date;
//		ResponseEntity<CurrencyExchangeAPI> currency=rest.getForEntity(uri, CurrencyExchangeAPI.class);
//		for (Map.Entry<String, Double> map : currency.getBody().getRates().entrySet())
//		{
//			Forex forex = new Forex(currency.getBody().getBase(), currency.getBody().getDate(), currency.getBody().getTimeLastUpdated(),
//					map.getKey(), map.getValue());
//			forexService.init(forex);
//		
//		}
	}
	@RequestMapping(method=RequestMethod.GET,value="/convert/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyExchange convert(@PathVariable String from,@PathVariable String to,@PathVariable Integer quantity) {
		Double exchangeFactor=forexService.convert(from,to);
		CurrencyExchange currency=new CurrencyExchange(from,to,quantity,exchangeFactor*quantity);
		
		return currency;
	}
}