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
		//���ƣ�ƻ����������2����ۣ�5.50(Ԫ)��С�ƣ�10.45(Ԫ)����ʡ0.55(Ԫ)
		StringBuffer printInfo = new StringBuffer(super.setPrintInfo(billDetail));
		printInfo.append("����ʡ");
		printInfo.append(billDetail.getDiscountTotal());
		printInfo.append("(Ԫ)");
		billDetail.setPrintInfo(printInfo.toString());
	}

}
