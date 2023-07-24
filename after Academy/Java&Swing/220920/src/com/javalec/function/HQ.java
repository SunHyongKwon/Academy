package com.javalec.function;

public class HQ {
	
	public HQ() {
		// TODO Auto-generated constructor stub
	}
	
	public void print() {
		orderKim();
		orderBoo();
		orderBi();
		orderSoon();
		orderKong();
	}
	
	public void orderKim() {
		System.out.println("김치찌개 (HQ) : 5,000원");
	}
	
	public void orderBoo() {
		System.out.println("부대찌개 (HQ) : 6,000원");
	}
	
	public void orderBi() {
		System.out.println("비빔밥 (HQ) : 6,000원");
	}
	
	public void orderSoon() {
		System.out.println("순대국 (HQ) : 5,000원");
	}
	
	public void orderKong() {
		System.out.println("공기밥 (HQ) : 1,000원");
	}
	
}
