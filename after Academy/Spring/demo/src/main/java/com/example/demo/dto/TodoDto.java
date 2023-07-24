package com.example.demo.dto;

import java.sql.Timestamp;

public class TodoDto {
	
	int tdcode;
	Timestamp initdate;
	Timestamp deletedate;
	String content;
	String uid;
	
	
	public int getTdcode() {
		return tdcode;
	}
	public void setTdcode(int tdcode) {
		this.tdcode = tdcode;
	}
	public Timestamp getInitdate() {
		return initdate;
	}
	public void setInitdate(Timestamp initdate) {
		this.initdate = initdate;
	}
	public Timestamp getDeletedate() {
		return deletedate;
	}
	public void setDeletedate(Timestamp deletedate) {
		this.deletedate = deletedate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
