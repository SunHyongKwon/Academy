<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "cart_04.jsp" method = "post">
	
	<h2>상품 선택 저장 결과</h2>
	<%
		String result = request.getParameter("result");
		String str = "";
		if(result.equals("o")){
			str = "저장 되었습니다. <br>";
		}else{
			str = "저장되지 않았습니다.<br>";
		}
	%>
	
	<%=str %>
	
	<input type = "submit" value = "저장 결과 불러오기 ">
	</form>
</body>
</html>