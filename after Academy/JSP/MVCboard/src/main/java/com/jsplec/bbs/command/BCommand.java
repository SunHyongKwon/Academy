package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 메소드 이름을 맞추기 위해서 하는 것
public interface BCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
