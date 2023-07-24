<%@page import="com.jsplec.bean.Bean_01"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Bean_01 product = new Bean_01();
		product.setName("eraser");
		product.setValue(1000);
		
		request.setAttribute("product", product);
	%>
	
	<jsp:forward page="elbean_2.jsp" />
</body>
</html>