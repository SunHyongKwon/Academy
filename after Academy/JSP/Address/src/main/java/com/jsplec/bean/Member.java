package com.jsplec.bean;

public class Member {
	private int seq;
	private String name;
	private String tel;
	private String address;
	private String email;
	private String relation;
	// member에 같이 넣어서 갈려고
	private String result;
	
	public Member() {
		
	}

	public Member(int seq, String name, String tel, String address, String email, String relation) {
		super();
		this.seq = seq;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}
	
	public Member(String name, String tel, String address, String email, String relation, String result) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.relation = relation;
		this.result = result;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	
}
