<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입 결과</h2>
	가입 되셨습니다. 
	<br>
	<br>
	<h2>가입 내용</h2>
	아이디 : <%=session.getAttribute("id") %> <br>
	패스워드 : <%=session.getAttribute("pw") %><br>
	이름 : <%=session.getAttribute("name") %><br>
</body>
</html>