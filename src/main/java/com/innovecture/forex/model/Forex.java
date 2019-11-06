package com.innovecture.forex.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="forex")
public class Forex {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "base")
	private String base;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	@Column(name = "timeLastUpdated")
	private long timeLastUpdated;

	@Column(name = "toCurrency")
	private String toCurrency;
	
	@Column(name = "exchangeRate")
	private Double exchangeRate;
	
	public Forex() {
		super();
	}

	public Forex( String base, Date date, long timeLastUpdated, String toCurrency, Double exchangeRate) {
		super();
		this.base = base;
		this.date = date;
		this.timeLastUpdated = timeLastUpdated;
		this.toCurrency = toCurrency;
		this.exchangeRate = exchangeRate;
	}

	public Long getId() {
		return id;
	}

	public String getBase() {
		return base;
	}

	public java.util.Date getDate() {
		return date;
	}

	public long getTimeLastUpdated() {
		return timeLastUpdated;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	@Override
	public String toString() {
		return "Forex [id=" + id + ", base=" + base + ", date=" + date + ", timeLastUpdated=" + timeLastUpdated
				+ ", toCurrency=" + toCurrency + ", exchangeRate=" + exchangeRate + "]";
	}

	
	
	}
