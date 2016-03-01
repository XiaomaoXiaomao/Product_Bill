package com.entity;

public class ProductDiscount {
	private String barCode;
	private String discountCode;
	private int priority;
	
	public static int PRIORITY_FIRST = 1;
	public static int PRIORITY_SECOND = 2;
	
	public ProductDiscount(String barCode, String discountCode, int priority) {
		this.barCode = barCode;
		this.discountCode = discountCode;
		this.priority = priority;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
