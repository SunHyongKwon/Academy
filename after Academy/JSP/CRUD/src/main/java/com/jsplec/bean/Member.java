package com.jsplec.bean;

public class Member {
	private String userid;
	private String name;
	private String tel;
	private String address;
	private String result;
	private String insertdate;
	private int num;


	

	

	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String userid, String name, String tel, String address) {
		super();
		this.userid = userid;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	public Member(String userid, String name, String tel, String address, String result) {
		super();
		this.userid = userid;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.result = result;
	}
	
	public Member(String userid, String name, String tel, String address, String insertdate, int num) {
		super();
		this.userid = userid;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.insertdate = insertdate;
		this.num = num;
	}
	
	public String getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
