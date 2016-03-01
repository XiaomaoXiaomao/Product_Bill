package com.repository;

import com.entity.BillDetail;
import com.entity.Discount;
import com.entity.DiscountNone;
import com.entity.DiscountPresent;
import com.entity.DiscountRate;
import com.interfaces.DiscountAccountInterface;

public class DiscountFactory {
	private String discountCode;
	private DiscountAccountInterface discAccount;
	
	public DiscountFactory(String discountCode){
		this.discountCode = discountCode;
		if(discountCode.equals(Discount.DISCOUNT_PRESENT_2_1)){
			discAccount = new DiscountPresent(2, 1);
		}else if(discountCode.equals(Discount.DISCOUNT_RATE_95)){
			discAccount = new DiscountRate(0.95);
		}else{
			discAccount = new DiscountNone();
		}
	}
	
	public String getDiscountCode() {
		return discountCode;
	}



	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}



	public DiscountAccountInterface getDiscAccount() {
		return discAccount;
	}



	public void setDiscAccount(DiscountAccountInterface discAccount) {
		this.discAccount = discAccount;
	}



	public void account(BillDetail billDetail){
		discAccount.account(billDetail);
	}
	
}
