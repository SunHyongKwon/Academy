package com.javalec.function;

public class Child2 extends Lunch {
	
	// Constructor
	public Child2() {
		
	}
	
	public Child2(int rice, int bulgogi, int banana, int almond, int milk) {
		super(rice, bulgogi, banana, almond, milk);
	}

	// Method
	@Override
	public int choose() {
		
		return rice + bulgogi + milk + almond;
		
	}

}
