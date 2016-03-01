package com.entity;

public class Discount {
	public static final String DISCOUNT_NONE = "";
	public static final String DISCOUNT_RATE_95 = "RATE_95";
	public static final String DISCOUNT_PRESENT_2_1 = "PRESENT_2_1";
	
	//名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)
	public String setPrintInfo(BillDetail billDetail){
		StringBuffer printInfo =new StringBuffer();
		Product product = billDetail.getProduct();
		
		printInfo.append("名称：");
		printInfo.append(product.getName());
		printInfo.append(",数量：");
		printInfo.append(billDetail.getProductCount());
		printInfo.append(product.getUnit());
		printInfo.append("，单价：");
		printInfo.append(product.getPrice());
		printInfo.append("(元)，小计：");
		printInfo.append(billDetail.getCurrentTotal());
		printInfo.append("(元)");
		billDetail.setPrintInfo(printInfo.toString());
		
		return billDetail.getPrintInfo();
	}
}
