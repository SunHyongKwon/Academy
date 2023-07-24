package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.BDaoService02;

@Controller
public class BController02 {
	
	@Autowired
	BDaoService02 service;
	
	// 게시판 작성 후 입력 버튼 누를 시
	@RequestMapping("/write")
	public String write(HttpServletRequest request) throws Exception{
		
		
		service.writeDao(request);
		
		return "redirect:list";
	}
	
	
	// 수정 버튼 클릭 시 
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request) throws Exception {
		
		service.modifyDao(request);
		
		
		return "redirect:list";
	}
	
	// 수정 버튼 클릭 시 
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception {
		
		service.deleteDao(request);
		
		
		return "redirect:list";
	}
	
	
}
