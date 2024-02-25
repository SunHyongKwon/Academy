<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method ="get">
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<h2><%=request.getParameter("kind") %></h2>
	당신의 나이는 <%=request.getParameter("age") %>살 이므로 주류구매가 <%=request.getParameter("purchase") %>합니다.<br>
	<a href = "http://localhost:8080/221020/ResponseAge_01.jsp">처음으로 이동 </a>
</form>
</body>
</html>