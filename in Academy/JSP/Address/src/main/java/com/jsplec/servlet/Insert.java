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


@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String name;
	private String tel;
	private String address;
	private String email;
	private String relation;
	

    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		name = request.getParameter("name");
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		address = request.getParameter("address");
		
		
		tel = phone1 + "-" + phone2 + "-" + phone3;
		
		email = request.getParameter("email");
		relation = request.getParameter("relation");
		
		String result = insertAction();
		Member member = new Member(name,tel,address,email,relation,result);
		
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseInsert_03.jsp");
		dispatcher.forward(request, response);

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private String insertAction() {
		AddressDAO dao = new AddressDAO(name,tel,address,email,relation);
		
		if(dao.insertAction()) {
			return "데이터가 올바르게 입력되었습니다.";
		}else {
			return "아이디가 중복입니다.";
		}
	}
	
	
}
