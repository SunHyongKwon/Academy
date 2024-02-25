package com.jsplec.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sum")
public class Sum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Sum() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total = 0;
		HttpSession session = request.getSession(); 
		
		for(int i = 1; i<= 100; i++) {
			total += i;
		}
		
		request.setAttribute("sum", total);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sum100.jsp");
		dispatcher.forward(request, response);
	}

	
}
