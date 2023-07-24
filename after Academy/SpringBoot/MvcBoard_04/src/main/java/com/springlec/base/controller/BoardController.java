package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.dto.MovieDto;
import com.springlec.base.service.MovieService;

@Controller
public class BoardController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		List<MovieDto> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
		
	}
	
}
