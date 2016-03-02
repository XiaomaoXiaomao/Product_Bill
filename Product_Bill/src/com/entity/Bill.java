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
	 ***<ûǮ׬�̵�>�����嵥***
	���ƣ��ɿڿ��֣�������3ƿ�����ۣ�3.00(Ԫ)��С�ƣ�6.00(Ԫ)
	���ƣ���ë��������6�������ۣ�1.00(Ԫ)��С�ƣ�4.00(Ԫ)
	���ƣ�ƻ����������2����ۣ�5.50(Ԫ)��С�ƣ�10.45(Ԫ)����ʡ0.55(Ԫ)
	----------------------
	�����һ��Ʒ��
	���ƣ��ɿڿ��֣�������1ƿ
	���ƣ���ë��������2��
	----------------------
	�ܼƣ�20.45(Ԫ)
	��ʡ��5.55(Ԫ)
	**********************
	 */
	public StringBuffer print(){
		//order bill detail
		Collections.sort(billDetailList, new CompBulkAfterCountOrder());
		
		StringBuffer stringBuf = new StringBuffer();
		Printer.print("***<ûǮ׬�̵�>�����嵥***");
		for(BillDetail billDetail : billDetailList){
			Printer.print(billDetail.getPrintInfo());
		}
		Printer.print("----------------------");
		
		int presentCount = 0;
		for(BillDetail billDetail : billDetailList){
			if(billDetail.getDiscount().getDiscountCode().equals(Discount.DISCOUNT_PRESENT_2_1)){
				if(billDetail.getDiscountTotal() != 0){
					if(presentCount == 0){
						Printer.print("�����һ��Ʒ��");
					}
					presentCount++;
					Printer.print(billDetail.getDiscountInfo());
				}
			}
		}
		if(presentCount > 0){
			Printer.print("----------------------");
		}
		
		
		Printer.print("�ܼƣ�" + currentTotal + "(Ԫ)");
		if(discountTotal != 0){
			Printer.print("��ʡ��" + discountTotal + "(Ԫ)");
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
