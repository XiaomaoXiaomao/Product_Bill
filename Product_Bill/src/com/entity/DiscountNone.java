package com.entity;

import com.interfaces.DiscountAccountInterface;

public class DiscountNone extends Discount implements DiscountAccountInterface{

	@Override
	public void account(BillDetail billDetail) {
		Product product = billDetail.getProduct();
		int count = billDetail.getProductCount();
		double originalTotal = product.getPrice() * count;
		double currentTotal;
		double discountTotal;
		
		currentTotal = originalTotal;
		discountTotal = 0;
		
		billDetail.setOriginalTotal(originalTotal);
		billDetail.setCurrentTotal(currentTotal);
		billDetail.setDiscountTotal(discountTotal);
		//名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)
		super.setPrintInfo(billDetail);
	}

}
