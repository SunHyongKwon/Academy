<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>입력에 성공하셨습니다.</h3>
	
	<p> 아이디 : ${param.id }
	<p> 비밀번호 : ${param.pw }
	<p> 이름 : ${param.name }
	<p> 전화번호 : ${param.phone1 } - ${param.phone2 } - ${param.phone3 }
	<p> 이메일 : ${param.email }
</body>
</html>