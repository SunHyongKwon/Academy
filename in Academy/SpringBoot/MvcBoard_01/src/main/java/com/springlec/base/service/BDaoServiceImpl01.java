package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.BDao;
import com.springlec.base.model.BDto;

@Service
public class BDaoServiceImpl01 implements BDaoService01 {
	
	@Autowired
	BDao dao;

	@Override
	public void listDao(Model model) throws Exception {
		
		model.addAttribute("list", dao.listDao());
	}


	@Override
	public void selectBoard(HttpServletRequest request, Model model) throws Exception {
		
		String bId = request.getParameter("bId");
		
		BDto dto = dao.selectBoard(bId);
		
		model.addAttribute("content_view",dto);
	}



}
