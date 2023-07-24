package com.javalec.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javalec.function.Customer;

public class MainEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 첫번째 예제
//		List<Integer> list = new ArrayList<>();
//		int num;
//		
//		System.out.print("입력할 숫자의 갯수 ? ");
//		num = sc.nextInt();
//		System.out.println(num+"개의 숫자를 입력하세요! : ");
//		
//		for(int i=0;i<num;i++) {
//			System.out.print((i+1) +"의 숫자 : ");
//			list.add(sc.nextInt());
//		}
//		
//		System.out.print("몇번째의 숫자를 삭제 하시겠습니까? : ");
//		list.remove(sc.nextInt()-1);
//		
//		System.out.println("--------- 결과 -----------");
//		for(int a : list) {
//			System.out.println(a);
//		}
		
		// 두번째 예제
		List<Customer> list2 = new ArrayList<>();
		boolean exit = true;
		int num , cnt = 1;
		String name, phone ,exitString;
		
		while(exit) {
			System.out.print("숫자 : ");
			num = sc.nextInt();
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("번호 : ");
			phone = sc.next();
			list2.add(new Customer(num,name,phone));
			
			System.out.println("그만 추가하고 싶음?? 그럼 apple을 쳐봐");
			
			exitString = sc.next();
			
			if(exitString.equals("apple") || cnt == 10) {
				if(cnt == 10) System.out.println("나 좀 쉬게 해줘 힘드렁");
				exit = false;
			}
			cnt++;
		}
		
		for(Customer customer : list2) {
			System.out.println(customer.getNumber() + "\t | " + customer.getName() + "\t | " + customer.getPhone() );
		}
		
		System.out.println(list2.toString().replaceAll(",",""));
	}
}


