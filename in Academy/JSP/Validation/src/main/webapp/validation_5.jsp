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
		var regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
		var regExpName = /^[가-힣]{3}$/
		var regExpPw = /^[0-9]{4,}$/
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
		
		
		var form = document.Member
		
		var id = form.id.value
		var pw = form.pw.value
		var name = form.name.value
		var phone = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value
		var email = form.email.value
		
		if(!regExpId.test(id)){
			alert("id는 문자로 시작해주세요")
			form.id.select()
			return
		}
		
		if(!regExpName.test(name)){
			alert("name는 한글만 적어주세요")
			form.name.select()
			return
		}
		
		if(!regExpPw.test(pw)){
			alert("pw는 숫자만 적어주세요")
			form.pw.select()
			return
		}
		
		if(!regExpPhone.test(phone)){
			alert("###-####-#### 에 맞게 적어주세요")
			form.phone2.select()
			return
		}
		
		if(!regExpEmail.test(email)){
			alert("####@####.###에 맞게 적어주세요")
			form.email.select()
			return
		}
		
		form.submit()  
	}
	
</script>
<body>
	<form name = "Member" action = "validation_5_process.jsp" >
		<p>ID : <input type = "text" name = "id">
		<p>PW : <input type = "password" name = "pw">
		<p>이름 : <input type = "text" name = "name">
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
		
		<p> 이메일 : <input type = "text" name ="email">
		<p><input type ="button" value ="ok" onclick="checkMember()">
	</form>
</body>
</html>