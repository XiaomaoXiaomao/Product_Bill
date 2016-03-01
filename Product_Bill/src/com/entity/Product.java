package com.entity;

public class Product {
	
	private String barCode;
	private String name;
	private double price;
	private String unit;
	

	public Product(String barCode, String name, double price, String unit) {
		super();
		this.barCode = barCode;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
