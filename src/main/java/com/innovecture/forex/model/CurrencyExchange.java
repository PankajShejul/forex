package com.innovecture.forex.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyExchange {
	private String from;
	private String to;
	private Integer quantity;
	private Double totalCalculatedAmount;
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange(String from, String to, Integer quantity, Double totalCalculatedAmount) {
		super();
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(Double totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	@Override
	public String toString() {
		return "CurrencyExchange [from=" + from + ", to=" + to + ", quantity=" + quantity + ", totalCalculatedAmount="
				+ totalCalculatedAmount + "]";
	}
	
	
}
