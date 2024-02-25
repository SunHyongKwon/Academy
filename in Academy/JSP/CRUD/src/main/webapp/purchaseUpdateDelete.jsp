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
		var regExpId = /^[a-z|A-Z]{1,10}$/
		var regExpName = /^[가-힣]{1,20}$/
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpAddress = /^[가-힣0-9 ]{1,50}$/
		
		var form = document.UD
		
		var id = form.id.value
		var name = form.name.value
		var phone = form.tel.value
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
		
		form.action = "update"
		form.submit()  
	}
	
	
</script>
<body>
	<h3>수정 후 확인 버튼을 누르세요!</h3>
	
	<form action = "delete" name = "UD">
		<p> 사용자 ID : <input type="text" name="id" size="10" value="${member.userid}" readonly="true"> <br>
		<o> 성명 : <input type="text" name="name" size="20" value="${member.name}"> <br>
		<o> 전화번호 : <input type="text" name="tel" size="30" value="${member.tel}"> <br>
		<o> 주소 : <input type="text" name="address" size="40" value="${member.address}"> <br>
		<br>
		<input type = "button" value = "수정" onclick="checkMember()">
		<br>
		<input type = "submit" value = "삭제">
	</form>
</body>
</html>