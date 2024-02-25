package com.javalec.function;

public abstract class Lunch {
	// field
	public int rice ;
	public int bulgogi;
	public int banana;
	public int almond;
	public int milk;

	// constructor
	public Lunch() {

	}

	public Lunch(int rice, int bulgogi, int banana, int almond, int milk) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.banana = banana;
		this.almond = almond;
		this.milk = milk;
	}

	// method
	public abstract int choose();
	
	

}
