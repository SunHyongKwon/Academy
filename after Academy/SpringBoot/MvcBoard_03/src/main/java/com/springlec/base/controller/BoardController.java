package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.dto.AddressDto;
import com.springlec.base.service.AddressService;

@Controller
public class BoardController {
	
	@Autowired
	AddressService service;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		
		List<AddressDto> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) throws Exception{
		String query = request.getParameter("query");
		String search = request.getParameter("search");		
		
		List<AddressDto> list = service.queryList(query, search);
		
		model.addAttribute("list", list);
		
		return "list";
		
	}
	
}
