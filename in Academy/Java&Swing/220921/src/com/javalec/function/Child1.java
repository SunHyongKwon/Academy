package com.javalec.function;

public class Child1 extends Lunch {
	
	// Constructor
	public Child1() {
		
	}
	
	public Child1(int rice, int bulgogi, int banana, int almond, int milk) {
		super(rice, bulgogi, banana, almond, milk);
	}

	// Method
	@Override
	public int choose() {
		return rice + bulgogi + banana;
		
	}

}
