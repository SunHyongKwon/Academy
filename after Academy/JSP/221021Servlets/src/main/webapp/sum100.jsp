<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이 방식 말고 밑의 방식으로 넘겨줘야 javascript 쓰시는 front 분들이 이해함 -->
	1부터 100까지의 합은  <%=request.getAttribute("sum") %> <br>
	1부터 100까지의 합은  ${sum} <br> 
</body>
</html>