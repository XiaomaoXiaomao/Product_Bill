package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.entity.Discount;
import com.entity.ProductDiscount;

public class ProductDiscountList {
	private static List<ProductDiscount> productDiscountList = new ArrayList<ProductDiscount>();
	
	public static void add(ProductDiscount productDiscount){
		productDiscountList.add(productDiscount);
	}

	public static List<ProductDiscount> getProductDiscountList() {
		return productDiscountList;
	}

	public static void setProductDiscountList(List<ProductDiscount> productDiscountList) {
		ProductDiscountList.productDiscountList = productDiscountList;
	}
	
	public static ProductDiscount findByBarCodeAndPriority(String barCode, int priority){
		for(ProductDiscount productDiscount : productDiscountList){
			if(barCode.equals(productDiscount.getBarCode()) 
					&& priority == productDiscount.getPriority()){
				return productDiscount;
			}
		}
		return new ProductDiscount(barCode, Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST);
	}
	
}
