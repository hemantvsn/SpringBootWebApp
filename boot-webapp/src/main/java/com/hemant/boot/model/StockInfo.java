package com.hemant.boot.model;

public class StockInfo {
	private String symbol;
	private double price = -1;
	private double yearHigh = -1;
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
