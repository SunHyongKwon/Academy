<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	sum_02 <br>
	지시자 이용하여 에러페이지 이동 방법 <br>
	<form action = "sum_02.jsp" method = "get">
	<input type = "text" name = "num1" size = "10"> 
	+ 
	<input type = "text" name = "num2" size = "10">  
	<input type = "submit" value = "ok">  
	</form>
	<br>
	========================================================
	<br>
	sum_03 <br>	
	try-catch 이용하여 에러페이지 이동 방법 <br>
	<form action = "sum_03.jsp" method = "get">
	<input type = "text" name = "num1" size = "10"> 
	+ 
	<input type = "text" name = "num2" size = "10">  
	<input type = "submit" value = "ok">  
	</form>
</body>
</html>