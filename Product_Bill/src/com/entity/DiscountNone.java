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
		//���ƣ�ƻ����������2����ۣ�5.50(Ԫ)��С�ƣ�10.45(Ԫ)
		super.setPrintInfo(billDetail);
	}

}
