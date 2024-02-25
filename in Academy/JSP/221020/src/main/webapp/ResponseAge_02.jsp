<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    
<%
	request.setCharacterEncoding("UTF-8");
	String ageStr = request.getParameter("age");
	int age = Integer.parseInt(ageStr);
	String kind = "";
	String purchase = "";
	
	if(age >= 20){
		kind = "성인";
		purchase = "가능";
	}else{
		kind = "미성년자";
		purchase = "불가능";
	}
	
	response.sendRedirect("http://localhost:8080/221020/ResponseAge_03.jsp?age="+age+"&kind="+URLEncoder.encode(kind)+"&purchase="+URLEncoder.encode(purchase));
	
	
%>


	