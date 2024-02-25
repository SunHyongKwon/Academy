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
		var regExpId = /^[a-z|A-Z]{1,10}$/
		var regExpName = /^[가-힣]{1,20}$/
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpAddress = /^[가-힣0-9 ]{1,50}$/
		
		var form = document.Member
		
		var id = form.id.value
		var name = form.name.value
		var phone = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value
		var address = form.address.value
		
		if(!regExpId.test(id)){
			if(id == ""){
				alert("id를 입력해 주세요.")
			}else{
				alert("id는 영문만 가능합니다.")
			}
			form.id.select()
			return
		}
		
		if(!regExpName.test(name)){
			if(name == ""){
				alert("name을 입력해 주세요.")
			}else{
				alert("name은 한글만 가능합니다.")
			}
			
			form.name.select()
			return
		}
		
		if(!regExpPhone.test(phone)){
			if(phone == ""){
				alert("전화번호를 입력해 주세요.")
			}else{
				alert("전화번호 양식에 맞게 입력해 주세요.")
			}
			form.phone.select()
			return
		}
		
		if(!regExpAddress.test(address)){
			if(address == ""){
				alert("주소를 입력해 주세요.")
			}else{
				alert("주소는 한글과 숫자만 입력해 주세요")
			}
			form.email.select()
			return
		}
		
		form.submit()  
	}
	
</script>
<body>
	<h3>아래의 항목을 입력후 확인 버튼을 누르세요!</h3>
	
	<form action = "insert" name = "Member">
		<p> 사용자 ID : <input type = "text" name = "id">
		
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
		
		<p> <input type = "button" value = "등록" onclick="checkMember()"> 
	</form>
	
</body>
</html>