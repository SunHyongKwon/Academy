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


@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int seq;
	private String name;
       
    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		seq = Integer.parseInt(request.getParameter("seq"));
		name = request.getParameter("name");
		
		
		String result = deleteAction();
		Member member = new Member();
		
		member.setSeq(seq);
		member.setName(name);
		member.setResult(result);
		
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addressDelete_03.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String deleteAction() {
		AddressDAO dao = new AddressDAO(seq);
		
		boolean result = dao.deleteAction();
		
		if(result) {
			return "정보가 삭제 되었습니다.";
		}else {
			return "정보가 삭제 되지 않았습니다.";
		}
	}
	
}
