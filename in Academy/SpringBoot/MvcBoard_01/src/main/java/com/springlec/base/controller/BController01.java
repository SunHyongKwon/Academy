package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.BDaoService01;

@Controller
public class BController01 {
	
	@Autowired
	BDaoService01 service;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:list";
	}
	
	// 게시판 검색
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		
		service.listDao(model);
		
		return "list";
	}
	
	// 게시판에서 클릭 시 
	@RequestMapping("/write_view")
	public String listClick(){

		return "write_view";
	}
	
	// 게시판 번호 클릭 시
	@RequestMapping("/content_view")
	public String contentView(HttpServletRequest request, Model model) throws Exception {
		
		service.selectBoard(request, model);
		
		return "content_view";
	}
	

	
}
