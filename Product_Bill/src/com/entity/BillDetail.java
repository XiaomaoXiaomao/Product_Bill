package com.entity;

import com.repository.DiscountFactory;
import com.repository.ProductDiscountList;

public class BillDetail {
	private String billCode;
	private Product product;
	private int productCount;
	private DiscountFactory discount;
	private double originalTotal = 0;
	private double currentTotal = 0;
	private double discountTotal = 0;
	private String printInfo;
	private String discountInfo;
	
	public BillDetail(Product product, int productCount) {
		this.product = product;
		this.productCount = productCount;
		String discountCode = ProductDiscountList.findByBarCodeAndPriority(product.getBarCode(), ProductDiscount.PRIORITY_FIRST).getDiscountCode();
		discount = new DiscountFactory(discountCode);
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public DiscountFactory getDiscount() {
		return discount;
	}

	public void setDiscount(DiscountFactory discount) {
		this.discount = discount;
	}

	public double getOriginalTotal() {
		return originalTotal;
	}

	public void setOriginalTotal(double originalTotal) {
		this.originalTotal = originalTotal;
	}

	public double getCurrentTotal() {
		return currentTotal;
	}

	public void setCurrentTotal(double currentTotal) {
		this.currentTotal = currentTotal;
	}

	public double getDiscountTotal() {
		return discountTotal;
	}

	public void setDiscountTotal(double discountTotal) {
		this.discountTotal = discountTotal;
	}
	
	public String getPrintInfo() {
		return printInfo;
	}

	public void setPrintInfo(String printInfo) {
		this.printInfo = printInfo;
	}

	public String getDiscountInfo() {
		return discountInfo;
	}

	public void setDiscountInfo(String discountInfo) {
		this.discountInfo = discountInfo;
	}

	public void account(){
		discount.account(this);
	}
	
}
