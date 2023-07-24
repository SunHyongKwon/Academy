<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style> 
input[type=text],input[type=password] {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}

input[type=button],input[type=reset] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
label {
  font-size: 20px;
  line-height: 2rem;
  padding: 0.2em 0.4em;
}

span {
  vertical-align: middle;
}

[type="radio"] ,[type="checkbox"] {
  vertical-align: middle;
  border: max(2px, 0.1em) solid gray;
  border-radius: 50%;
  width: 1.25em;
  height: 1.25em;
}

</style>
<title> 사용자 정보 입력</title>
</head>
<body>
<form action = "RequestParameter.jsp" method = "get">

    이름 : <input type="text" name="name"><br>
    아이디 : <input type="text" name="id"><br>
    패스워드 : <input type="password" name="pw"><br>
    
    취미 : 
    <input type="checkbox" name="hobby" value="read" checked> 독서 
    <input type="checkbox" name="hobby" value="cook" checked> 요리  
    <input type="checkbox" name="hobby" value="jogging" checked> 조깅 
    <input type="checkbox" name="hobby" value="swim"> 수영 
    <br>
	
	전공 : 
	 <input type="radio" name="major" value="kor" checked> 국어
	 <input type="radio" name="major" value="eng"> 영어
	 <input type="radio" name="major" value="design" > 디자인
	<br>
	
	Protocol :
	<select name = "protocol">
	<option value = "http"> http </option>
	<option value = "https"> https </option>
	<option value = "smtp" selected = "selected"> smtp </option>
	<option value = "pop"> pop </option>
	</select>
	<br>
	
	<input type="submit" value="전송">
	
	
	<input type="reset" value="취소">
	
</form>
</body>
</html>