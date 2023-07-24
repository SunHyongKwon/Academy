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


@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int seq;
	private String name;
	private String tel;
	private String address;
	private String email;
	private String relation;
	
	private String result;
       

    public Update() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		seq = Integer.parseInt(request.getParameter("seq"));
		name = request.getParameter("name");
		tel = request.getParameter("tel");
		address = request.getParameter("address");
		email = request.getParameter("email");
		relation = request.getParameter("relation");
		
		boolean res = updateAction();
		Member member = selectAction();
		
		
		if(res) {
			member.setResult("상기의 정보로 수정되었습니다. 감사합니다.");
		}else {
			member.setResult("상기의 정보로 수정되지 않았습니다.감사합니다.");
		}
		
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addressUpdate_03.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private boolean updateAction() {
		AddressDAO dao = new AddressDAO(seq,name,tel,address,email,relation);
		
		boolean result = dao.updateAction();
		
		return result;
	}
	
	private Member selectAction() {
		AddressDAO dao = new AddressDAO(seq);
		
		Member member = dao.selectAction();
		
		return member;
	}
}
