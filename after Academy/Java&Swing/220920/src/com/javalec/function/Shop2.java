package com.javalec.function;

public class Shop2 extends HQ{

	public Shop2() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void orderBoo() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 5,000원");
	}
	
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 4,000원");
	}
	
	@Override
	public void orderKong() {
		System.out.println("공기밥 : 무료 입니다.");
	}
	
	
}
