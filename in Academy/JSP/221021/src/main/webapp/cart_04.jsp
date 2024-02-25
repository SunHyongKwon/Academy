<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	BufferedReader reader = null;
	String str2 = "";
	try{
		String filePath = application.getRealPath("input2.txt");
		reader = new BufferedReader(new FileReader(filePath));
		//파일리더로 읽어서 버퍼로 주소를저장한다
		while(true){
			String str = reader.readLine();
			if(str == null) break;
			str2 += str +"<br>";
		}
		
	}catch(FileNotFoundException fnfr){
		str2 = "파일이 존재하지 않습니다.";
	}catch(IOException ioe){
		str2 = "파일을 읽을 수 없습니다.";
	}finally{
			try{
				reader.close();
			}catch(Exception e){
			
		}
	}
	response.sendRedirect("http://localhost:8080/221021/cart_05.jsp?result="+URLEncoder.encode(str2));
%>