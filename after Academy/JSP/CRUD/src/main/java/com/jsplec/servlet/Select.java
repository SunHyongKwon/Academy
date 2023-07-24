package com.jsplec.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bean.Member;
import com.jsplec.dao.DaoPurcahseinfo;


@WebServlet("/select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String userid;

    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		userid = request.getParameter("id");
		
		HttpSession session = request.getSession();
		session.setAttribute("beforeid" , userid);
		
		Member member = selectAction();
		
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseUpdate_02.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private Member selectAction() {
		DaoPurcahseinfo dao = new DaoPurcahseinfo(userid);
		
		Member member = dao.selectAction();
		
		return member;
	}
}
