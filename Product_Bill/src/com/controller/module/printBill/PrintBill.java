package com.controller.module.printBill;

import java.util.Scanner;

import com.common.Printer;
import com.entity.Bill;
import com.entity.Discount;
import com.entity.Product;
import com.entity.ProductDiscount;
import com.repository.ProductDiscountList;
import com.repository.ProductList;

public class PrintBill {

	public static void main(String[] args) {
		printProductsInfo();
		
		intiProductDiscountList();
		
		String json = getProductsJson();
		Bill bill = new Bill(json);
		bill.account();
		bill.print();
	}
	
	public static void intiProductDiscountList(){
		/*//苹果
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//羽毛球
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//可乐
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));*/
		
		/*//苹果
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//羽毛球
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//可乐
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));*/
		
		/*//苹果
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_FIRST));
		//羽毛球
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));
		//可乐
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_NONE, ProductDiscount.PRIORITY_FIRST));*/
		
		/*//苹果
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_FIRST));
		//羽毛球
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//可乐
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));*/
		
		/*//苹果
		ProductDiscountList.add(new ProductDiscount("ITEM000003", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_FIRST));
		//羽毛球
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//可乐
		ProductDiscountList.add(new ProductDiscount("ITEM000005", Discount.DISCOUNT_PRESENT_2_1, ProductDiscount.PRIORITY_FIRST));
		//羽毛球
		ProductDiscountList.add(new ProductDiscount("ITEM000001", Discount.DISCOUNT_RATE_95, ProductDiscount.PRIORITY_SECOND));*/
		
		Printer.print("请输入 买二送一 商品条形码(注意数据正确且无重复，e.g. ['ITEM000001','ITEM000003'] 或 [])：");
		inputProductDiscount(Discount.DISCOUNT_PRESENT_2_1);
		
		Printer.print("请输入 95折  商品条形码(注意数据正确且无重复，e.g. ['ITEM000005'])： 或 [])：");
		inputProductDiscount(Discount.DISCOUNT_RATE_95);
		
		
	}
	
	private static void printProductsInfo(){
		Printer.print("商品信息:");
		for(Product product : ProductList.getProductList()){
			Printer.print("      条形码：" + product.getBarCode() 
					+ " 名称：" + product.getName() + "     单价：" + product.getPrice() + "/" + product.getUnit());
		}
		Printer.print("");
	}
	
	private static String getProductsJson(){
		Printer.print("");
		Printer.print("请输入购买商品的JSON数据(注意格式正确):");
		Printer.print("e.g. ['ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000003-2','ITEM000005','ITEM000005','ITEM000005']");
		String json;
		Scanner scan = new Scanner(System.in);
		json = scan.next();
		Printer.print("");
		if(json != null && !json.equals("")){
			return json;
		}else{
			return "['ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000003-2','ITEM000005','ITEM000005','ITEM000005']";
		}
	}
	
	private static void inputProductDiscount(String discountType){
		Scanner scan = new Scanner(System.in);
		String productDiscountInfo = scan.next();
		String[] productArray = productDiscountInfo.substring(1, productDiscountInfo.length() - 1).replaceAll("'","").split(",");
		for(String barCode : productArray){
			int priority;
			if(discountType.equals(Discount.DISCOUNT_PRESENT_2_1)){
				priority = ProductDiscount.PRIORITY_FIRST;
			}else{
				if(ProductDiscountList.findByBarCodeAndPriority(barCode, ProductDiscount.PRIORITY_FIRST)
						.getDiscountCode().equals(Discount.DISCOUNT_NONE)){
					priority = ProductDiscount.PRIORITY_FIRST;
				}else{
					priority = ProductDiscount.PRIORITY_SECOND;
				}
			}
			ProductDiscountList.add(new ProductDiscount(barCode, discountType, priority));
		}
	}

}
