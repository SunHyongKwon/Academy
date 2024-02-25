package com.jsplec.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CharacterTest_01S")
public class CharacterTest_01S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CharacterTest_01S() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foodArr = request.getParameterValues("food");
		
		String food = Arrays.toString(foodArr); 
		food = food.replaceAll("\\[", "");
		food = food.replaceAll("\\]", "");
		food = food.replaceAll(",", "과");
		
		String result = saveCharacterFile(name, color, animal, food);
		
		request.setAttribute("name", name);
		request.setAttribute("color", color);
		request.setAttribute("animal", animal);
		request.setAttribute("food", food);
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("characterTest_02.jsp");
		dispatcher.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String saveCharacterFile(String name, String color, String animal, String food) {

		String fileName = "charactertest.txt";
		String result = "";
		PrintWriter writer = null;
		
		try{
			String filePath = getServletContext().getRealPath(fileName);
			
			writer = new PrintWriter(filePath);
			writer.println("이름 : " + name);
			writer.println("색깔 : " + color);
			writer.println("동물 : " + animal);
			writer.println("음식 : " + food);
			
			result = "저장되었습니다.";
			
		}catch(IOException ioe){
			result = "파일에 데이터를 쓸 수 없습니다.";
		}finally{
			try{
				writer.close();
			}catch(Exception e){
				
			}
		}
		return result;
	}

}
