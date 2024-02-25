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
 	<!-- product.name 은 Bean_01 클래스의 name 필드를 말하는 것이 아니라 getName 메소드를 말하는 것이다. 
 	어떠한 방법을 통해 name을 getName()으로 만들고 이 함수를 호출하는 것이다. -->
	제품 이름 : ${product.name} <br>
	제품 이름 : ${product.value} <br>
</body>
</html>