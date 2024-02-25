package com.springlec.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Form_03 {
	
	@RequestMapping("/")
	public String index() {
		
		return "form";
	}
	
	@RequestMapping("/student")
	public String form(Model model, HttpServletRequest request) {
		String method = request.getMethod();
		
		String id = request.getParameter("id");
		
		model.addAttribute("id", id);
		model.addAttribute("method", method);
		
		return "student";
	}

	
}
