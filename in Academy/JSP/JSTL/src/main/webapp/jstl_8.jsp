<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사하기</title>
</head>
<body>
<!--자바에서 for문 같은 것 -->
<c:forEach var="cnt" begin="1" end="5">
	<font size="${cnt }">
		hi <br>
	</font>
</c:forEach>
</body>
</html>