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


@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String beforeid;
	private String name;
	private String tel;
	private String address;
	private String result;
       

    public Update() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		userid = request.getParameter("id");
		beforeid = (String) session.getAttribute("beforeid");
		name = request.getParameter("name");
		tel = request.getParameter("tel");
		address = request.getParameter("address");
		
		boolean res = updateAction();
		Member member = selectAction();
		
		
		if(res) {
			member.setResult("상기의 정보로 수정되었습니다. 감사합니다.");
		}else {
			member.setResult("상기의 정보로 수정되지 않았습니다.감사합니다.");
		}
		
		session.invalidate();
		
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseUpdate_03.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private boolean updateAction() {
		DaoPurcahseinfo dao = new DaoPurcahseinfo(userid,beforeid,name,tel,address);
		
		boolean result = dao.updateAction();
		
		return result;
	}
	
	private Member selectAction() {
		DaoPurcahseinfo dao = new DaoPurcahseinfo(userid);
		
		Member member = dao.selectAction();
		
		return member;
	}
}
