<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="com.jsplec.bean.Student" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="name" name="student" value="홍길동" />
	<jsp:setProperty property="age" name="student" value="13" />
	<jsp:setProperty property="grade" name="student" value="6" />
	<jsp:setProperty property="studentNum" name="student" value="10" />
	
	이름 : <jsp:getProperty property="name" name="student" /> <br>
	나이 : <jsp:getProperty property="age" name="student" /> <br>
	성적 : <jsp:getProperty property="grade" name="student" /> <br>
	학번 : <jsp:getProperty property="studentNum" name="student" /> <br>
</body>
</html>