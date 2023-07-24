<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style> 
input[type=text] {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}

input[type=submit] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<title>Insert title here</title>
</head>
<body>
	숫자 2개 입력해 주세요.
	<br>
	<br>
	<form action = "AddNumTwo.jsp" method = "">
		숫자1 <br><input type = "text" name = "num1"> <br>
		
		숫자2 <br><input type = "text" name = "num2"> <br>
	
		계산방법 : <br>
	 <input type="radio" name="operator" value="덧셈" checked> 덧셈 <br>
	 <input type="radio" name="operator" value="뺄셈"> 뺄셈<br>
	 <input type="radio" name="operator" value="곱셈" > 곱셈<br>
	 <input type="radio" name="operator" value="나눗셈" > 나눗셈 <br>
	<input type = "submit" value = "확인">
	</form>
</body>
</html>