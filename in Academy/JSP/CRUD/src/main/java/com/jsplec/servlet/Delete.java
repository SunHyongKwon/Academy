package com.jsplec.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bean.Member;
import com.jsplec.dao.DaoPurcahseinfo;


@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String userid;
       
    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		userid = request.getParameter("id");
		
		String result = deleteAction();
		Member member = new Member();
		
		member.setUserid(userid);
		member.setResult(result);
		
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseDelete_03.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String deleteAction() {
		DaoPurcahseinfo dao = new DaoPurcahseinfo(userid);
		
		boolean result = dao.deleteAction();
		
		if(result) {
			return "정보가 삭제 되었습니다.";
		}else {
			return "정보가 삭제 되지 않았습니다.";
		}
	}
	
}
