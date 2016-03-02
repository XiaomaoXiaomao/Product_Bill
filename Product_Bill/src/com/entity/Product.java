package com.entity;

public class Product {
	
	private String barCode;
	private String name;
	private double price;
	private String unit;
	/*1: in bulk; 0: not in bulk*/
	private String isInBulk;
	
	public Product(String barCode, String name, double price, String unit,
			String isInBulk) {
		super();
		this.barCode = barCode;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.isInBulk = isInBulk;
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

	public String getIsInBulk() {
		return isInBulk;
	}

	public void setIsInBulk(String isInBulk) {
		this.isInBulk = isInBulk;
	}
	
}
