package com.entity;

import com.common.MathTool;
import com.interfaces.DiscountAccountInterface;

public class DiscountRate extends Discount implements DiscountAccountInterface{
	private double rate = 1;
	
	public DiscountRate() {
	}
	
	public DiscountRate(double rate) {
		this.rate = rate;
	}

	@Override
	public void account(BillDetail billDetail) {
		Product product = billDetail.getProduct();
		int count = billDetail.getProductCount();
		double originalTotal = product.getPrice() * count;
		double currentTotal;
		double discountTotal;
		
		currentTotal = originalTotal * rate;
		currentTotal = MathTool.round(currentTotal);
		discountTotal = originalTotal - currentTotal;
		discountTotal = MathTool.round(discountTotal);
		
		billDetail.setOriginalTotal(originalTotal);
		billDetail.setCurrentTotal(currentTotal);
		billDetail.setDiscountTotal(discountTotal);
		//名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)，节省0.55(元)
		StringBuffer printInfo = new StringBuffer(super.setPrintInfo(billDetail));
		printInfo.append("，节省");
		printInfo.append(billDetail.getDiscountTotal());
		printInfo.append("(元)");
		billDetail.setPrintInfo(printInfo.toString());
	}

}
