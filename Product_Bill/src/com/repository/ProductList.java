package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.entity.Product;

public class ProductList {
	private static List<Product> productList = new ArrayList<Product>();
	
	static{
		add(new Product("ITEM000003","苹果",5.5,"斤","1"));
		add(new Product("ITEM000005","可口可乐",3,"瓶","0"));
		add(new Product("ITEM000001","羽毛球",1,"个","0"));
	}
	
	public static void add(Product product){
		productList.add(product);
	}
	
	public static List<Product> getProductList() {
		return productList;
	}

	public static void setProductList(List<Product> productList) {
		ProductList.productList = productList;
	}


	public static Product findByBarCode(String barCode){
		for(Product product : productList){
			if(barCode.equals(product.getBarCode())){
				return product;
			}
		}
		return null;
	}
}
