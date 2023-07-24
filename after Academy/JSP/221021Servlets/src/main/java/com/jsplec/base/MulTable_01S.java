package com.jsplec.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MulTable_01S
 */
@WebServlet("/MulTable_01S")
public class MulTable_01S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MulTable_01S() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int start = Integer.parseInt(request.getParameter("num1"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
//		request.setAttribute("result", gugudan(start));
		request.setAttribute("result", makeTable(start, cnt));
		RequestDispatcher dispatcher = request.getRequestDispatcher("MulTable_02.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String gugudan(int start) {
		String str = "";

		for (int i = 1; i <= 9; i++) {
			str += start + " X " + i + " = " + (start * i) + "<br>";
		}

		return str;
	}
	
	private String makeTable(int start, int cnt) {
		int rowCnt = 17;
		int columnCnt = cnt * 2 - 1;
		
		String str = "";

		str = "<table border=\"0\">";
		for (int i = 0; i < rowCnt; i++) {
		 str += "<tr>";
		  for (int j = 0; j < columnCnt; j++)  {
		    str += "<td>";
		    if(i % 2 == 0 && j % 2 == 0) {
		    	str += (start+ j/2) + " X " + (i/2 + 1) + " = " + ((start+j/2)*(i/2+1));
		    }
		    str += "</td>";
		  }
		 str += "</tr>";
		}
		str += "</table>";
		
		return str;
	}
	

}
