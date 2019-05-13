package com.mista.petroz.currencyexchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	@Id
	@Column(name="cid")
	private Long id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	private BigDecimal convertionMultiple;
	
	@Column(nullable=true)
	private int Port;
	
	protected ExchangeValue() {
		super();
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal covertionMultiple) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = covertionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}

	public void setConvertionMultiple(BigDecimal covertionMultiple) {
		this.convertionMultiple = covertionMultiple;
	}

	public int getPort() {
		
		return Port;
	}

	public void setPort(int port) {
		Port = port;
	}

}
