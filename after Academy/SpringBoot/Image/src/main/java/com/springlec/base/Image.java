package com.springlec.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Image {
	@RequestMapping("/")
	public String image(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("image", "sample2");
		
		return "index";
	}
	
	@RequestMapping("/select_image")
	public String imageSelect(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("image", request.getParameter("filename"));
		
		return "image";
	}
}
