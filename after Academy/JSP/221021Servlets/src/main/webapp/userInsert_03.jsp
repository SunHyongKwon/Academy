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
	request.setCharacterEncoding("UTF-8");
	
	String signin = request.getParameter("signin");

	if(signin.equals("agree")){
		response.sendRedirect("http://localhost:8080/221021Servlets/userInsert_04.jsp?result=success");	
	}else{
		session.invalidate();
		response.sendRedirect("http://localhost:8080/221021Servlets/userInsert_01.jsp");
	}
%>
</body>
</html>