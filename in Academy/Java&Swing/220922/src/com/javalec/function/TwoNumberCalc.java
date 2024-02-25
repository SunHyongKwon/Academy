package com.javalec.function;

public class TwoNumberCalc {
	
	// Field
	
	// Constructor
	public TwoNumberCalc() {
		// TODO Auto-generated constructor stub
	}
	
	// Method
	// add
	public String add(String str1, String str2) {
		
		return Integer.toString(Integer.parseInt(str1) + Integer.parseInt(str2));
	}
	
	
	public String sub(String str1, String str2) {
		
		return Integer.toString(Integer.parseInt(str1) - Integer.parseInt(str2));
	}
	
	
	public String mul(String str1, String str2) {
		
		return Integer.toString(Integer.parseInt(str1) * Integer.parseInt(str2));
	}
	
	
	public String div(String str1, String str2) {
		
		return String.format("%.2f",Double.parseDouble(str1) / Integer.parseInt(str2));
	}
	
}
