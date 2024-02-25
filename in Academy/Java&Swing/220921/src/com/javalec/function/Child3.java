package com.javalec.function;

public class Child3 extends Lunch {
	
	// Constructor
	public Child3() {
		
	}
	
	public Child3(int rice, int bulgogi, int banana, int almond, int milk) {
		super(rice, bulgogi, banana, almond, milk);
	}

	// Method
	@Override
	public int choose() {
		return rice + bulgogi;
	}

}
