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
import com.jsplec.dao.DaoPurcahseinfo;


@WebServlet("/MakeList")
public class MakeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MakeList() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoPurcahseinfo dao = new DaoPurcahseinfo();
		ArrayList<Member> userList = dao.selectAllAction();
		int size = userList.size();
		request.setAttribute("userList", userList);
		request.setAttribute("size", size);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchaseUserList.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
