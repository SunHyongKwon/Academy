package chap06;

public class Car {
	//필드
	String company = "기아";
	String model;
	String color;
	int maxSpeed;
	int speed;
	
	//생성자
	Car(){
	}
	
	Car(String model){
		this.model = model;
	}
	Car(String model,String color){
		this.model = model;
		this.color = color;
	}
	Car(String model,String color,int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	//메소드
	void setSpeed(int speed) {
		this.speed = speed;
	}
	int sum1(int ... values) {
		int sum = 0;
		for(int i=0;i<values.length;i++) {
			sum += values[i];
		}
		return sum;
	}
	void run1() {
		for(int i=10;i<=50;i +=10) {
			this.setSpeed(i);
			System.out.println(this.model +"가 달립니다.(시속:" + this.speed + "km/h");
		}
	}
	void run2() {
		for(int i=10;i<=50;i +=10) {
			setSpeed(i);
			System.out.println(model +"가 달립니다.(시속:" + speed + "km/h");
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
