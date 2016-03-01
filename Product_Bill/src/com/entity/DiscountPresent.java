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
			//���ƣ��ɿڿ��֣�������1ƿ
			billDetail.setDiscountInfo("���ƣ�" + product.getName() + "��������" + presentCount + product.getUnit());
		}else{
			currentTotal = originalTotal;
			discountTotal = 0;
		}
		
		billDetail.setOriginalTotal(originalTotal);
		billDetail.setCurrentTotal(currentTotal);
		billDetail.setDiscountTotal(discountTotal);
		//���ƣ�ƻ����������2����ۣ�5.50(Ԫ)��С�ƣ�10.45(Ԫ)
		super.setPrintInfo(billDetail);
	}

}
