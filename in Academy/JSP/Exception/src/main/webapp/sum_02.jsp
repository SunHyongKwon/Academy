<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="checkerror.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int one = Integer.parseInt(num1);
		int two = Integer.parseInt(num2);
		
		int result = one + two;
	%>
	
	<%=one %> + <%=two %> = <%=result %>
</body>
</html>