package com.springlec.base.dto;

public class BDto {
	int bId;
	String bName;
	String bContent;
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}

	public BDto(int bId, String bName, String bContent) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bContent = bContent;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
	
}
