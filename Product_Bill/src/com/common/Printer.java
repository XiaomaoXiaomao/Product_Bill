package com.common;

public class Printer {
	public static void printToConsole(StringBuffer stringBuf){
		System.out.println(stringBuf);
	}
	public static void printToConsole(String string){
		System.out.println(string);
	}
	
	public static void print(StringBuffer stringBuf){
		printToConsole(stringBuf);
	}
	public static void print(String string){
		printToConsole(string);
	}
}
