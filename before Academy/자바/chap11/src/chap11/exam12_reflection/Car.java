package chap11.exam12_reflection;

public class Car {
	//field
	private String model;
	private String owner;
	
	//constructor
	public Car() {
		
	}
	public Car(String model, String owner) {
		this.model = model;
		this.owner = owner;
	}
	
	//method
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOwner() {
		return owner;
	}
	private void setOwner(String owner) {
		this.owner = owner;
	}
}
