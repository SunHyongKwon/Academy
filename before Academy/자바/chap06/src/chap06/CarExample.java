package chap06;

public class CarExample {
	public static void main(String[] args) {
		//다양한 방법으로 생성자 생성 
		Car car1 = new Car();
		Car car2_1 = new Car("K8");
		Car car2_2 = new Car("Porsche");
		Car car3 = new Car("Sorento","gray");
		Car car4 = new Car("GV80","black",320);
		Car sum = new Car();
		
		System.out.println("car1 모델명 : " + car1.model);
		System.out.println("car2 모델명 : " + car2_1.model);
		System.out.println("car3 모델명 : " + car3.model);
		System.out.println("car4 모델명 : " + car4.model);
		
		int sumExam = sum.sum1(15,24,33,42,50);
		System.out.println("sum : " + sumExam);
		System.out.println("-----------------------------------");
		car2_1.run1();
		car2_1.run2();
		car2_2.run1();
		car2_2.run2();
	}
}
