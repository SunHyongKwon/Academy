package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.CalcService;

@Controller
public class Example {
	
	@Autowired
	CalcService service;
	
	@RequestMapping("/")
	public String index() {
		return "calc";
	}
	
	@RequestMapping("/calc")
	public String add(Model model , HttpServletRequest request) throws Exception{
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		int addResult = service.addAction(num1, num2);
		int minusResult = service.minusAction(num1, num2);
		int multiResult = service.multiAction(num1, num2);
		double divideResult = service.divideAction(num1, num2);
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("addition", addResult);
		model.addAttribute("minus", minusResult);
		model.addAttribute("multi", multiResult);
		model.addAttribute("divide", divideResult);
		
		return "calcResult";
	}
}
