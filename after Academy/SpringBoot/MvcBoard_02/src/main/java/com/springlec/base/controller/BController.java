package com.springlec.base.controller;

import java.util.List;import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.dto.BDto;
import com.springlec.base.service.BDaoService;

@Controller
public class BController {
	@Autowired
	BDaoService service;
	
	@RequestMapping("/")
	public String index() {
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		List<BDto> list = service.list();
		
		model.addAttribute("list",list);
		
		return "list";
		
	}
	
	// 글작성 클릭시
	@RequestMapping("/write_view")
	public String writeView() {
		return "write_view";
	}
	
	// 글작성 에서 입력 누를 시
	@RequestMapping("/write")
	public String write(HttpServletRequest request) throws Exception {
		String bName =request.getParameter("bName");
		String bContent = request.getParameter("bContent");
		
		service.write(bName, bContent);
		
		return "redirect:list";
	}
	
	// X 버튼 누를 시
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception{
		String bId = request.getParameter("bId");
		
		service.delete(bId);
		
		return "redirect:list";
	}
	
}
