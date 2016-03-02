package com.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.common.CompBulkAfterCountOrder;
import com.common.Printer;
import com.repository.ProductList;

public class Bill {
	private List<BillDetail> billDetailList = new LinkedList<BillDetail>();
	private double originalTotal = 0;
	private double currentTotal = 0;
	private double discountTotal = 0;
	
	public Bill(String json){
		setBillDetailList(json);
		
	}
	
	public void account(){
		for(BillDetail billDetail : billDetailList){
			billDetail.account();
			originalTotal += billDetail.getOriginalTotal();
			currentTotal += billDetail.getCurrentTotal();
			discountTotal += billDetail.getDiscountTotal();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	/**
	 ***<没钱赚商店>购物清单***
	名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)
	名称：羽毛球，数量：6个，单价：1.00(元)，小计：4.00(元)
	名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)，节省0.55(元)
	----------------------
	买二赠一商品：
	名称：可口可乐，数量：1瓶
	名称：羽毛球，数量：2个
	----------------------
	总计：20.45(元)
	节省：5.55(元)
	**********************
	 */
	public StringBuffer print(){
		//order bill detail
		Collections.sort(billDetailList, new CompBulkAfterCountOrder());
		
		StringBuffer stringBuf = new StringBuffer();
		Printer.print("***<没钱赚商店>购物清单***");
		for(BillDetail billDetail : billDetailList){
			Printer.print(billDetail.getPrintInfo());
		}
		Printer.print("----------------------");
		
		int presentCount = 0;
		for(BillDetail billDetail : billDetailList){
			if(billDetail.getDiscount().getDiscountCode().equals(Discount.DISCOUNT_PRESENT_2_1)){
				if(billDetail.getDiscountTotal() != 0){
					if(presentCount == 0){
						Printer.print("买二赠一商品：");
					}
					presentCount++;
					Printer.print(billDetail.getDiscountInfo());
				}
			}
		}
		if(presentCount > 0){
			Printer.print("----------------------");
		}
		
		
		Printer.print("总计：" + currentTotal + "(元)");
		if(discountTotal != 0){
			Printer.print("节省：" + discountTotal + "(元)");
		}
		Printer.print("**********************");
		
		return stringBuf;
	}
	
	private void setBillDetailList(String json){
		String tmpJson = json.substring(1, json.length()-1).replaceAll("'","");
		String[] barCodes = tmpJson.split(",");
		List<String> barCodeList = Arrays.asList(barCodes);
		Collections.sort(barCodeList);
		barCodes = (String[]) barCodeList.toArray();
		
		String lastBarCode = "";
		
		for(int i = 0; i < barCodes.length; i++){
			//filter detail info without bar code
			if(barCodes[i].startsWith("-")){
				break;
			}
			
			int count;
			String[] codeCount = barCodes[i].split("-");
			if(codeCount.length == 1){
				count = 1;
			}else if(codeCount.length == 2){
				count = Integer.parseInt(codeCount[1]);
			}else{
				break;
			}
			
			if(lastBarCode.equals(codeCount[0])){
				if(billDetailList.size() > 0){
					int lastIndex = billDetailList.size()-1;
					int originalCount = billDetailList.get(lastIndex).getProductCount();
					billDetailList.get(lastIndex).setProductCount(originalCount + count);
				}else{
					break;
				}
			}else{
				Product product = ProductList.findByBarCode(codeCount[0]);
				if(product != null){
					BillDetail billDtail = new BillDetail(product, count);
					billDetailList.add(billDtail);
					lastBarCode = codeCount[0];
				}
			}
		}
	}
}
