<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

	function checkMember(){
		
		var form = document.Member
		
		form.submit()  
	}
	
</script>
<body>
	<h3>아래의 항목을 입력후 확인 버튼을 누르세요!</h3>
	
	<form action = "insert" name = "Member">
		<p> 성명 : <input type = "text" name = "name">
		
		<p>전화번호 : 
		<select name = "phone1">
			<option value = "010">010</option>
			<option value = "011">011</option>
			<option value = "016">016</option>
			<option value = "017">017</option>
			<option value = "019">019</option>
		</select>
		-
		<input type = "text" maxlength = "4" size = "4" name = "phone2">
		-
		<input type = "text" maxlength = "4" size = "4" name = "phone3">
		
		<p> 주소 : <input type = "text" name = "address">
		<p> 전자우편 : <input type = "text" name = "email">
		<p> 관계 : <input type = "text" name = "relation">
		
		<p> <input type = "button" value = "등록" onclick="checkMember()"> 
	</form>
	
</body>
</html>