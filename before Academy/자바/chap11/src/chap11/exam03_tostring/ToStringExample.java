package chap11.exam03_tostring;

import java.util.Date;

public class ToStringExample {

	public static void main(String[] args) {
		Object obj = new Object();
		Date date = new Date();
		String string = new String("abc");
		SmartPhone smartphone = new SmartPhone("samsung","android");
		System.out.println(obj);
		System.out.println(date);
		System.out.println(string);
		System.out.println(smartphone);
	}

}
