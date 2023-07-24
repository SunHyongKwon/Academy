package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Form {
	
	@RequestMapping("/")
	public String form() {
		return "index";
	}
}
