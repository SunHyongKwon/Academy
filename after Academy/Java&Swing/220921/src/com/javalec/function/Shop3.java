package com.javalec.function;

public class Shop3 extends HQ {

	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 6,000원");
	}
	@Override
	public void orderBoo() {
		System.out.println("부대찌개 : 7,000원");
	}
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 7,000원");
	}
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 6,000원");
	}
	
	@Override
	public void orderKong() {
		// TODO Auto-generated method stub
		
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
