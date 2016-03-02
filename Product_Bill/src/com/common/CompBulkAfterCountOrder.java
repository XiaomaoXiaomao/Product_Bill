package com.common;

import java.util.Comparator;

import com.entity.BillDetail;
import com.entity.Product;

public class CompBulkAfterCountOrder implements Comparator<BillDetail>{

	@Override
	public int compare(BillDetail o1, BillDetail o2) {
		Product p1 = o1.getProduct();
		Product p2 = o2.getProduct();
		
		int result = Integer.parseInt(p1.getIsInBulk()) - Integer.parseInt(p2.getIsInBulk());
		if(result == 0){
			return o1.getProductCount()-o2.getProductCount();
		}else{
			return result;
		}
	}

}
