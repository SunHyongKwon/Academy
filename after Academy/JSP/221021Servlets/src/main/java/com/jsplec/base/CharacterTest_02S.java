package com.jsplec.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CharacterTest_02S")
public class CharacterTest_02S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CharacterTest_02S() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		BufferedReader reader = null;
		String str1 = "";
		try{
			String filePath = getServletContext().getRealPath("charactertest.txt");
			reader = new BufferedReader(new FileReader(filePath));
			//파일리더로 읽어서 버퍼로 주소를저장한다
			while(true){
				String str = reader.readLine();
				if(str == null) break;
				str1 += str + "<br>";
			}
			
		}catch(FileNotFoundException fnfr){
			str1 = "파일이 존재하지 않습니다.";
		}catch(IOException ioe){
			str1 = "파일을 읽을 수 없습니다.";
		}finally{
			try{
				reader.close();
			}catch(Exception e){
				
			}
		}
		request.setAttribute("file", str1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("characterTest_03.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
