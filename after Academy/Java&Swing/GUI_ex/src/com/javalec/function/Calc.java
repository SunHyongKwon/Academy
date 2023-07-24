package com.javalec.function;

public class Calc {
	private int num1;
	private int num2;
	
	
	public Calc() {
		// TODO Auto-generated constructor stub
	}
	
	public Calc(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int add() {
		return num1 + num2;
	}
	public int sub() {
		return num1 - num2;
	}
	public int mul() {
		return num1 * num2;
	}
	public double div() {
		return (double) num1 / num2;
	}
}
