package com.javalec.function;

public class Constructor {

	// Field
	public String company = "현대 자동차";
	public String model;
	public String color;
	public int maxSpeed;

	// Constructor
	public Constructor() {

	}

	public Constructor(String model) {
		this.model = model;
	}

	public Constructor(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	public Constructor(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	// Method

}
