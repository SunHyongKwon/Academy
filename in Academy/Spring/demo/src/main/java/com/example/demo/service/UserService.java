package com.example.demo.service;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	public void loginCheck(HttpServletRequest request, Model model) throws Exception;
}
