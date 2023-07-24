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
		
		// id , pw 입력되었는지 안되었는지 
		if(form.id.value == ""){
			alert("아이디를 입력해 주세요!");
			form.id.focus();
			return false;
		}else if(form.pw.value == ""){
			alert("비밀번호를 입력해 주세요!");
			form.pw.focus();
			return false;
		}
		
		// id , pw 가 최소 자리수를 넘겼는지 
		if(form.id.value.length < 4 || form.id.value.length > 12){
			alert("아이디는 4에서 12글자 이내로 입력 가능합니다.");
			form.id.select();
			return;
		}
		
		if(form.pw.value.length < 4 || form.pw.value.length > 12){
			alert("비밀번호는 4에서 12글자 이내로 입력 가능합니다.");
			form.pw.select();
			return;
		}
			
		
		form.submit(); // form을 제출해서 validation_2_process.jsp로 넘어가는 것이다.  
	}
</script>
<body>
	<form action = "validation_3_process.jsp" name = "loginForm">
		<p>ID : <input type = "text" name = "id">
		<p>PW : <input type = "password" name = "pw">
		<p><input type = "button" value = "ok" onclick="checkLogin()">
	</form>
</body>
</html>