package com.entity;

public class Discount {
	public static final String DISCOUNT_NONE = "";
	public static final String DISCOUNT_RATE_95 = "RATE_95";
	public static final String DISCOUNT_PRESENT_2_1 = "PRESENT_2_1";
	
	//���ƣ�ƻ����������2����ۣ�5.50(Ԫ)��С�ƣ�10.45(Ԫ)
	public String setPrintInfo(BillDetail billDetail){
		StringBuffer printInfo =new StringBuffer();
		Product product = billDetail.getProduct();
		
		printInfo.append("���ƣ�");
		printInfo.append(product.getName());
		printInfo.append(",������");
		printInfo.append(billDetail.getProductCount());
		printInfo.append(product.getUnit());
		printInfo.append("�����ۣ�");
		printInfo.append(product.getPrice());
		printInfo.append("(Ԫ)��С�ƣ�");
		printInfo.append(billDetail.getCurrentTotal());
		printInfo.append("(Ԫ)");
		billDetail.setPrintInfo(printInfo.toString());
		
		return billDetail.getPrintInfo();
	}
}
