<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style> 
input[type=text] , input[type=password]{
  width: 100%;
  padding: 10px 5px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 1px solid #555;
  outline: none;
}

input[type=text]:focus , input[type=password]:focus{
  background-color: lightgray;
}

 input[type=submit] {
  background-color: #8BC9F5;
  border: none;
  color: white;
  padding: 10px 25px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  alignment : right-align;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<form action = "userInsert_02.jsp" method = "get">
		개인정보를 입력하세요.
		<br>
		<table border = "0" width = "500" height = "5">
		<tr>
		<td> 아이디 : </td> 
		<td><input type = "text" name = "id"> </td>
		</tr>
		<tr>
		<td> 비밀번호 : </td> 
		<td><input type = "password" name = "pw"> </td>
		</tr>
		<tr>
		<td> 이름 : </td> 
		<td><input type = "text" name = "name"> </td>
		</tr>
		</table>
		
		<br>
		<br>
		
		<table border = "0" , width = "500">
		<tr>
		<td></td>
		<td><input type = "submit" value = "확인"></td>
		</tr>
		</table>
	</form>
</body>
</html>