<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반갑습니다.</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8"); // 한글 입력받게 될 경우에는 이 코드를 넣어주어야 % 문자를 utf-8로 인코딩 해준다. 
%>
	안녕하세요. <%=request.getParameter("yourname")  %> 님!
</body>
</html>