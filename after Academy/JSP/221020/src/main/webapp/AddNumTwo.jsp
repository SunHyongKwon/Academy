<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String strNum1 = request.getParameter("num1");
		String strNum2 = request.getParameter("num2");
		String[] operator = request.getParameterValues("operator");
	%>

	<%!
		public String operator(String num3, String num4 , String[] operatorArr){
		
		int num1 = Integer.parseInt(num3);
		int num2 = Integer.parseInt(num4);
		double result = 0;
		String str = "";

		for(String operator : operatorArr){
			switch(operator){
			case "덧셈":
				result = num1 + num2;
				str += "두 수의 " + operator + "은 " + result + "입니다.<br>";
				break;
			case "뺄셈":
				result = num1 - num2;
				str += "두 수의 " + operator + "은 " + result + "입니다.<br>";
				break;
			case "곱셈":
				result = num1 * num2;
				str += "두 수의 " + operator + "은 " + result + "입니다.<br>";
				break;
			case "나눗셈":
				if(num2 != 0){
					result = (double)num1 / num2;
				}else{
					result = 0; 
				}
				str += "두 수의 " + operator + "은 " + result + "입니다.<br>";
				break;
			}
			
			}
		
		return str; 
	}
	%>
	
	<%!
		public String operator2(String num3, String num4 , String[] operatorArr){
		
		int num1 = Integer.parseInt(num3);
		int num2 = Integer.parseInt(num4);
		double result = 0;
		
		String str1 = Arrays.toString(operatorArr);
		String str = "";
		
		if(str1.contains("덧셈")){
			result = num1 + num2;
			str += "두 수의 덧셈은 " + result + "입니다.<br>";
		}
		
		if(str1.contains("뺄셈")){
			result = num1 - num2;
			str += "두 수의 뺄셈은 " + result + "입니다.<br>";
		}
		
		if(str1.contains("곱셈")){
			result = num1 * num2;
			str += "두 수의 곱셈은 " + result + "입니다.<br>";
		}
		
		if(str1.contains("나눗셈")){
			if(num2 != 0){
				result = (double)num1 / num2;
			}else{
				result = 0; 
			}
			str += "두 수의 나눗셈은 " + result + "입니다.<br>";
		}
		
		return str; 
	}
	%>
	
	
	<%=Arrays.toString(operator) %>
	
	<br>
	
	<%=operator(strNum1,strNum2,operator) %>
	
	<hr>
	
	<%=operator2(strNum1,strNum2,operator) %>
</body>
</html>