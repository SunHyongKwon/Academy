<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "Bmi_01.jsp" method = "post">
	<table border = "0">
	<tr>
	
		<td> 키(cm) : </td> 
		<td> <input type="text" name="height" size = "10"> </td>
		
	</tr>
	
	<tr>
		<td> kg : </td> 
		<td> <input type="text" name="weight" size = "10"> </td>
	</tr>

	<tr>
		<td></td>
		<td><input type = "submit" value = "calc BMI"></td>
	</tr>
		
	</table>
	</form>
</body>
</html>