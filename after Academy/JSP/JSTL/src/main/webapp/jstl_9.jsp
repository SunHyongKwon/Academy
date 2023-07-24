<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사하기</title>
</head>
<body>
<%
	String[] arr = {"food1", "food2" , "food3"};
	request.setAttribute("arr",arr);
%>

	<jsp:forward page="jstl_10.jsp" />
	
</body>
</html>