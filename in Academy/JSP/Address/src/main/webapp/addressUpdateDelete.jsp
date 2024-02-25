<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkMember(){
		
		var form = document.UD;
		
		form.action = "update";
		form.submit();
	}
</script>
<body>
	<h3>수정 후 확인 버튼을 누르세요!</h3>
	
	<form action = "delete" name = "UD">
		<p> 사용자 ID : <input type="text" name="seq" size="10" value="${member.seq}" readonly="true"> <br>
		<p> 성명 : <input type="text" name="name" size="20" value="${member.name}"> <br>
		<p> 전화번호 : <input type="text" name="tel" size="30" value="${member.tel}"> <br>
		<p> 주소 : <input type="text" name="address" size="40" value="${member.address}"> <br>
		<p> 전자우편 : <input type="text" name="email" size="40" value="${member.email}"> <br>
		<p> 관계 : <input type="text" name="relation" size="40" value="${member.relation}"> <br>
		<br>
		<input type = "button" value = "수정" onclick="checkMember()">
		<br>
		<input type = "submit" value = "삭제">
	</form>
</body>
</html>