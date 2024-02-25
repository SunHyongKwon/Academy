package com.javalec.function.example02;

public class DivideNumAndSum {
	
	
	public String divideNumAndSum(int num) {
		int sum = 0;
		
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		
		return "Sum of digits = " + sum;
	}
	
	
}
