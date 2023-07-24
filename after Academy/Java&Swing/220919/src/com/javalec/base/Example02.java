package com.javalec.base;

import java.util.Scanner;
import java.util.function.Function;

import com.javalec.function.example02.DivideNumAndSum;

public class Example02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		// digit 받아오기
		System.out.print("Enter an integer(0 ~ 9) : ");
		num = sc.nextInt();
		
		// 받아온 숫자를 하나씩 나누어서 더하기
		// 그리고 그걸 출력하기
		// 클래스 이용 방법
		System.out.println(new DivideNumAndSum().divideNumAndSum(num));
		
		// 람다식 사용하기
		Function<Integer,String> result = number -> {
			int sum = 0;
			
			while(number > 0) {
				sum += number % 10;
				number /= 10;
			}
			
			return "Sum of digits = " + sum;
		};
		
		// 람다식 사용해서 출력
		System.out.println(result.apply(num));
		
		
	}

}
