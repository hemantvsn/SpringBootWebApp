package com.hemant.boot.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StockInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -346325450725372141L;
	private String symbol;
	@JsonProperty("Open")
	private double price = -1;
	@JsonProperty("YearHigh")
	private double yearHigh = -1;
	@JsonProperty("YearLow")
	private double yearLow = -1;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getYearHigh() {
		return yearHigh;
	}

	public void setYearHigh(double yearHigh) {
		this.yearHigh = yearHigh;
	}

	public double getYearLow() {
		return yearLow;
	}

	public void setYearLow(double yearLow) {
		this.yearLow = yearLow;
	}

	@Override
	public String toString() {
		return "StockInfo [symbol=" + symbol + ", price=" + price + ", yearHigh=" + yearHigh + ", yearLow=" + yearLow
				+ "]";
	}

}
