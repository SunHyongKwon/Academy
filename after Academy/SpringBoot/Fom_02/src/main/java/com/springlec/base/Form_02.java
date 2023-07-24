package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Form_02 {
	
	// pathVariable -> get 방식도 아니고 post 방식도 아닌 무언가
	// a href로 보낼 때 pathVariable를 붙여서 보내주면 된다. 
	@RequestMapping("/student/{studentId}/{id}/{name}")
	public String getStudent(@PathVariable String studentId,@PathVariable String id,@PathVariable String name , Model model) {
		
		model.addAttribute("studentId", studentId);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "/student/studentView";
	}
	
}
