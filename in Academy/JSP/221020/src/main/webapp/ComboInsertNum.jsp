<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- combobox의 숫자를 내가 지정해줅 수 있는 메소드 -->
<%!
	public String optionNum(int num){
	String str = "";
	for(int i=0;i<=num;i++){
		str += "<option value = " + i + " > " + i + "</option>";
	}
	return str;
}
%>

	숫자 2개 입력해 주세요.
	<br>
	<br>
	<form action = "AddNumTwo.jsp" method = "post">
	숫자 1 : <select name = "num1">
	<%
		out.println(optionNum(100));
	%>
	</select>
	
	숫자 2 : <select name = "num2">
	<%
		out.println(optionNum(100));
	%>
	</select>
	
	<br>
	
	계산방법 : <br>
	 <input type="checkbox" name="operator" value="덧셈" checked> 덧셈 <br>
	 <input type="checkbox" name="operator" value="뺄셈"> 뺄셈<br>
	 <input type="checkbox" name="operator" value="곱셈" > 곱셈<br>
	 <input type="checkbox" name="operator" value="나눗셈" > 나눗셈 <br>
	<input type = "submit" value = "확인">
	</form>
</body>
</html>