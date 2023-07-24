<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkLogin(){
		var form = document.loginForm;
		if(form.id.value == ""){
			alert("아이디를 입력해 주세요!");
			form.id.focus();
			return false;
		}else if(form.pw.value == ""){
			alert("비밀번호를 입력해 주세요!");
			form.pw.focus();
			return false;
		}
		form.submit(); // form을 제출해서 validation_2_process.jsp로 넘어가는 것이다.  
	}
</script>
<body>
	<form action = "validation_2_process.jsp" name = "loginForm">
		<p>ID : <input type = "text" name = "id">
		<p>PW : <input type = "password" name = "pw">
		<p><input type = "button" value = "ok" onclick="checkLogin()">
	</form>
</body>
</html>