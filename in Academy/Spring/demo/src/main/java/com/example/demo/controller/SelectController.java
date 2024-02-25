package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.PostService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/select")
public class SelectController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request, Model model) throws Exception{
		userService.loginCheck(request, model);
		
		return "login_check";
	}
	
	@RequestMapping("/post")
	public String post(Model model) throws Exception{
		postService.post(model);
		
		return "post";
	}
	
	@RequestMapping("/calendar")
	public String calendar(Model model) throws Exception{
		postService.post(model);
		
		return "calendar";
	}
}
