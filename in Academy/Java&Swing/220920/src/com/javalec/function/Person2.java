package com.javalec.function;

public class Person2 {

	public String getGift(int num) throws MinusException{
		Gift.giftNum -= num;
		
		if(Gift.giftNum == 0) {
			throw new MinusException("남은 선물 갯수가 없습니다."
					+ "\n--------------------");
		}else if(Gift.giftNum < 0) {
			throw new MinusException("남은 선물 갯수가 모자랍니다."
					+ "\n----------------------");
		}
		
		return "남은 선물 갯수는 " + Gift.giftNum + "개 입니다."
				+ "\n----------------------";
	}
	
	
}


class Person<T> {
	T t;
}