<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>맞게 입력하셨나요??</h3>
	
	<p> 사용자 ID : ${member.userid}
	<p> 성명 : ${member.name}
	<p> 전화번호 : ${member.tel}
	<p> 주소 : ${member.address}
	
	<br>
	
	<p> ${member.result }

</body>
</html>