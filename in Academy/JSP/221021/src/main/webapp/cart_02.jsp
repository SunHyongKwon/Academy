<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String quantity = request.getParameter("quantity");
	String size = request.getParameter("size");
	String color = request.getParameter("color");
	
	String fileName = "input2.txt";
	String result = "";
	PrintWriter writer = null;
	
	try{
		String filePath = application.getRealPath(fileName);
		
		writer = new PrintWriter(filePath);
		writer.println("수량 : " + quantity);
		writer.println("크키 : " + size);
		writer.println("색상 : " + color);
		
		result = "o";
		
	}catch(IOException ioe){
		result = "x";
	}finally{
		try{
			writer.close();
		}catch(Exception e){
			
		}
	}
	response.sendRedirect("http://localhost:8080/221021/cart_03.jsp?result="+URLEncoder.encode(result));
%>