package com.javalec.function;

public class ChildMenu extends ParentsMenu {

	public ChildMenu() {
		
	}

	public void makeBeefChung() {
		System.out.println("소고기 청국장");
	}

	public void makeHotDoen() {
		System.out.println("얼큰 된장국");
	}

	public void makeKongna() {
		System.out.println("콩나물 해장국");
	}

	@Override
	public void makeChung() {
		System.out.println("냄새 없는 청국장");
	}
	
}
