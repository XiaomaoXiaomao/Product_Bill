package com.entity;

import com.common.MathTool;
import com.interfaces.DiscountAccountInterface;

public class DiscountPresent extends Discount implements DiscountAccountInterface{
	private int buyCount;
	private int presentCount;
	
	public DiscountPresent(int buyCount, int presentCount) {
		this.buyCount = buyCount;
		this.presentCount = presentCount;
	}

	@Override
	public void account(BillDetail billDetail) {
		Product product = billDetail.getProduct();
		int count = billDetail.getProductCount();
		double originalTotal = product.getPrice() * count;
		double currentTotal;
		double discountTotal;
		if(count >= buyCount){
			currentTotal = product.getPrice() * (count - presentCount);
			discountTotal = originalTotal - currentTotal;
			discountTotal = MathTool.round(discountTotal);
			//名称：可口可乐，数量：1瓶
			billDetail.setDiscountInfo("名称：" + product.getName() + "，数量：" + presentCount + product.getUnit());
		}else{
			currentTotal = originalTotal;
			discountTotal = 0;
		}
		
		billDetail.setOriginalTotal(originalTotal);
		billDetail.setCurrentTotal(currentTotal);
		billDetail.setDiscountTotal(discountTotal);
		//名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)
		super.setPrintInfo(billDetail);
	}

}
