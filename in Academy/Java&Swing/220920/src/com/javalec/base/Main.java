package com.javalec.base;

import com.javalec.function.Child;
import com.javalec.function.ChildMenu;
import com.javalec.function.Constructor;
import com.javalec.function.FirstSon;
import com.javalec.function.HQ;
import com.javalec.function.SecondSon;
import com.javalec.function.Shop1;
import com.javalec.function.Shop2;
import com.javalec.function.Shop3;

public class Main {

	public static void main(String[] args) {

		// constructor overloading 하는 법
		Constructor car1 = new Constructor();
		System.out.println("car1 company\t: " + car1.company);

		System.out.println("==========================================");

		Constructor car2 = new Constructor("자가용");
		System.out.println("car2 company\t: " + car2.company);
		System.out.println("car2 model\t: " + car2.model);

		System.out.println("==========================================");

		Constructor car3 = new Constructor("자가용", "빨강");
		System.out.println("car3 company\t: " + car3.company);
		System.out.println("car3 model\t: " + car3.model);
		System.out.println("car3 color\t: " + car3.color);
		
		System.out.println("==========================================");

		Constructor car4 = new Constructor("택시", "검정", 200);
		System.out.println("car4 company\t: " + car4.company);
		System.out.println("car4 model\t: " + car4.model);
		System.out.println("car4 color\t: " + car4.color);
		System.out.println("car4 maxSpeed\t: " + car4.maxSpeed);
		
		// 클래스 상속 받기
		Child child = new Child();
		child.getFather();
		child.getMother();
		
		// 클래스 상속 받기 2
		ChildMenu child2 = new ChildMenu();
		child2.makeChung();
		child2.makeDoen();
		
		// 클래스 상속 받기 3
		HQ hq = new HQ();
		System.out.println("HQ ---------------------");
		hq.print();

		hq = new Shop1();

		System.out.println("Shop1 -----------------");
		hq.print();

		hq = new Shop2();

		System.out.println("Shop2 -----------------");
		hq.print();

		hq = new Shop3();

		System.out.println("Shop3 -----------------");
		hq.print();
		System.out.println("-----------------------");

		HQ[] hqArr = { new HQ(), new Shop1(), new Shop2(), new Shop3() };

		for (HQ hi : hqArr) {
			hi.print();
			System.out.println("-----------------------");
		}

		// 예외 처리
		int i = 10;
		int j = 0;

		System.out.println(i + j);
		System.out.println(i - j);
		System.out.println(i * j);
		try {
			System.out.println(i / j);
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		
		// static 클래스 메소드
		FirstSon first = new FirstSon();
		SecondSon second = new SecondSon();
		first.takeChoco();
		second.takeChoco();
		
	}

}
