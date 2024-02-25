package com.jsplec.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bean.Member;
import com.jsplec.dao.AddressDAO;

@WebServlet("/select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int seq;

    public Select() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		seq = Integer.parseInt(request.getParameter("seq"));
		
		Member member = selectAction();
		
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addressUpdateDelete.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private Member selectAction() {
		AddressDAO dao = new AddressDAO(seq);
		
		Member member = dao.selectAction();
		
		return member;
	}
}
