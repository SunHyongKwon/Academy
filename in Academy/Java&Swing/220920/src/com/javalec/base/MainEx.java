package com.javalec.base;

import java.util.Scanner;

import com.javalec.function.MinusException;
import com.javalec.function.Person2;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int personGiftNum;

		System.out.print("1번 친구에게 선물할 갯수를 입력하세요 : ");
		personGiftNum = sc.nextInt();

		Person2 one = new Person2();

		try {

			System.out.println(one.getGift(personGiftNum));
			System.out.print("2번 친구에게 선물할 갯수를 입력하세요 : ");
			personGiftNum = sc.nextInt();

			Person2 two = new Person2();
			System.out.println(two.getGift(personGiftNum));

		} catch (MinusException e) {

			System.out.println(e.getMessage());

		}
	}

}
