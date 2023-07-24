package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingEx {
	
	@RequestMapping("/student")
	public String functionOne(Model model, HttpServletRequest request) {
		String studentId = request.getParameter("studentId");
		
		if(studentId.equals("abc")) {
			return "redirect:studentOK";
		}else {
			return "redirect:studentNG";
		}
	}
	
	@RequestMapping("/studentOK")
	public String functionTwo() {
		return "student/studentOK";
	}
	
	@RequestMapping("/studentNG")
	public String functionThree() {
		return "student/studentNG";
	}
}
