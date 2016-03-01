package com.common;

import java.text.DecimalFormat;

public class MathTool {
	//2 bits after the point 
	public static double round(Double num){
		DecimalFormat format = new DecimalFormat("#.##");
		return Double.parseDouble(format.format(num));
	}
}
