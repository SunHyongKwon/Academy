package chap07.exam02;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		for(int i=0;i<10;i++) {
			int problemLocation = car.run();
			if(problemLocation != 0) {
				car.tires[problemLocation-1] = new KumhoTire(car.tires[problemLocation-1].location,15);
			}
		}
		
	}
}
