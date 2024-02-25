package com.javalec.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.javalec.function.Child1;
import com.javalec.function.Child2;
import com.javalec.function.Child3;
import com.javalec.function.Customer;
import com.javalec.function.HQ;
import com.javalec.function.Lunch;
import com.javalec.function.PriceTable;
import com.javalec.function.Shop1;
import com.javalec.function.Shop2;
import com.javalec.function.Shop3;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 클래스 상속 받기
		HQ hq = new Shop1();

		System.out.println("Shop1 -----------------");
		hq.printMenu();

		hq = new Shop2();

		System.out.println("Shop2 -----------------");
		hq.printMenu();
		hq = new Shop3();

		System.out.println("Shop3 -----------------");
		hq.printMenu();
		System.out.println("-----------------------");

		HQ[] hqArr = { new Shop1(), new Shop2(), new Shop3() };

		for (HQ hi : hqArr) {
			hi.printMenu();
			System.out.println("-----------------------");
		}
		
		// 추상 클래스를 이용해서 간단한 메뉴 고르기 시스템 만들어 보기
		Lunch child1 = new Child1(PriceTable.RICE,PriceTable.BULGOGI,PriceTable.BANANA,PriceTable.ALMOND,PriceTable.MILK);
		Lunch child2 = new Child2(PriceTable.RICE,PriceTable.BULGOGI,PriceTable.BANANA,PriceTable.ALMOND,PriceTable.MILK);
		Lunch child3 = new Child3(PriceTable.RICE,PriceTable.BULGOGI,PriceTable.BANANA,PriceTable.ALMOND,PriceTable.MILK);
		
		System.out.println("내야 할 금액 : " + child1.choose());
		System.out.println("내야 할 금액 : " + child2.choose());
		System.out.println("내야 할 금액 : " + child3.choose());
		
		// Collection Framework
		ArrayList<String> list = new ArrayList<>();
		
		//	Data 추가
		list.add("hi");
		list.add("bye1");
		list.add("bye2");
		list.add("bye3");
		
		// Data 읽기
		System.out.println(list.toString());
		System.out.println(list.get(2));	
		
		// Data 변경하기
		list.set(0, "str");
		System.out.println(list.get(0));
		
		// Data 삭제하기
		list.remove(0);
		list.remove("bye1");
		System.out.println(list);
		
		// 크기 알기
		System.out.println(list.size());
		
		// for문으로 전체 데이터 알기
		for(int i = 0; i< list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		// 클래스 객체로 list 만들기
		List<Customer> list2 = new ArrayList<>();
		
		list2.add(new Customer(1,"James","010-1111-2222"));
		
		Customer customer = new Customer();
		customer.setName("michael");
		customer.setNumber(1);
		customer.setPhone("010-2222-3333");
		list2.add(customer);
		
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		
		// Map 사용해보기
		Map<Integer, String> map = new HashMap<>();
		map.put(10,"Str10");
		map.put(11,"Str10");
		map.put(12,"Str10");
		System.out.println(map);
		System.out.println(map.get(10));
		Set<Integer> mapSet = map.keySet();
		Iterator<Integer> it = mapSet.iterator();
		
		while(it.hasNext()) {
			int key = it.next();
			String value = map.get(key);
			
			System.out.println(key + " , " + value);
		}

	}

}
