package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BDaoService01 {
	
	public void listDao(Model model) throws Exception;
	public void selectBoard(HttpServletRequest request, Model model) throws Exception;

}
