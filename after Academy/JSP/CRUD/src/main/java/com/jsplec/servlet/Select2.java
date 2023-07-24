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

@WebServlet("/select2")
public class Select2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String userid;

	public Select2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		userid = request.getParameter("id");

		boolean result = checkId();
		if (result) {
			Member member = selectAction();

			request.setAttribute("member", member);
			RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseDelete_02.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			request.setAttribute("userid", userid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseDelete_error.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private Member selectAction() {
		DaoPurcahseinfo dao = new DaoPurcahseinfo(userid);

		Member member = dao.selectAction();

		return member;
	}

	private boolean checkId() {

		DaoPurcahseinfo dao = new DaoPurcahseinfo(userid);
		int count = dao.checkId();

		if (count == 1) {
			return true;
		}
		return false;
	}
}
