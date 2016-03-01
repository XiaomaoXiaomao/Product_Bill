package com.controller.module.printBill;

import com.entity.Bill;
import com.entity.Discount;
import com.entity.ProductDiscount;
import com.repository.ProductDiscountList;

public class PrintBill {

	public static void main(String[] args) {
		intiProductDiscountList();
		
		String json = "['ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000003-2','ITEM000005','ITEM000005','ITEM000005']";
		Bill bill = new Bill(json);
		bill.account();
		bill.print();
	}
	
	public static void intiProductDiscountList(){
		/*//ƻ��
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//��ë��
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//����
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));*/
		
		/*//ƻ��
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//��ë��
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//����
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));*/
		
		/*//ƻ��
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_FIRST));
		//��ë��
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//����
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));*/
		
		/*//ƻ��
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_FIRST));
		//��ë��
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//����
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));*/
		
		//ƻ��
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_FIRST));
		//��ë��
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//����
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//��ë��
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_SECOND));
	}

}
