package com.jsplec.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bean.Member;
import com.jsplec.dao.AddressDAO;


@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String queryName;
	String queryContent;

    public Search() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		queryName = request.getParameter("query");
		queryContent = request.getParameter("content");
		
		if(queryName == null) {
			queryName = "address";
			queryContent = "";
		}
		
		ArrayList<Member> userList = selectQueryAction();
		int size = userList.size();
		
		request.setAttribute("userList", userList);
		request.setAttribute("size", size);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addressUserList.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private ArrayList<Member> selectQueryAction(){
		AddressDAO dao = new AddressDAO(queryName,queryContent);
		
		ArrayList<Member> list = dao.selectQueryAction();
		
		return list;
	}
	
}
