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
	String food = request.getParameter("animal");
	session.setAttribute("animal", food); // 서버 메모리에 저장되어서 static 처럼 사용할 수 있다.
%>

	당신은 <%=session.getAttribute("food") %> 와 <%=session.getAttribute("animal") %> 를 좋아하는 성격입니다. 
	
<%
	session.invalidate();
%>

</body>
</html>