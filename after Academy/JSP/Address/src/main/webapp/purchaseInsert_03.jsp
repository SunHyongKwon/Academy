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
	
	<p> 성명 : ${member.name}
	<p> 전화번호 : ${member.tel}
	<p> 주소 : ${member.address}
	<p> 전자우편 : ${member.email}
	<p>관계 : ${member.relation}
	
	<br>
	
	<p> ${member.result }

</body>
</html>