package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

public interface BDaoService02 {
	
	public void writeDao(HttpServletRequest request) throws Exception;
	public void modifyDao(HttpServletRequest request) throws Exception;
	public void deleteDao(HttpServletRequest request) throws Exception;

}
