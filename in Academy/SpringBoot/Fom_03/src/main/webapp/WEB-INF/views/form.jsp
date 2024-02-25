<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="student" method="get">
		Get <br> Student id : <input type="text" name="id"> <input
			type="submit" value="전송">
	</form>
	<br>

	<hr>
	
	<form action="student" method="post">
		Post <br> Student id : <input type="text" name="id"> <input
			type="submit" value="전송">
	</form>
	<br>

</body>
</html>