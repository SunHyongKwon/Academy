package com.javalec.function;

public class Shop1 extends HQ {

	public Shop1() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 4,500원");
	}
	
	@Override
	public void orderBoo() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 판매하지 않습니다.");
	}

	@Override
	public void orderBi() {
		System.out.println("부대찌개 : 5,000원");
	}

	@Override
	public void orderKong() {
		System.out.println("공기밥 : 1,000원");
	}

	@Override
	public void printMenu() {
		orderKim();
		orderBi();
		orderBoo();
		orderKong();
		orderSoon();
		
	}
}
