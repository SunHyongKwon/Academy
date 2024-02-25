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
<!-- java의 switch 같은  -->
<c:choose>

	<c:when test="${param.num1 == 0 }">
		처음 뵙겠습니다. <br>
	</c:when>
	<c:when test="${param.num1 == 1 }">
		한번 뵙겠습니다. <br>
	</c:when>
	<c:when test="${param.num1 == 2 }">
		두번 뵙겠습니다. <br>
	</c:when>
</c:choose>
</body>
</html>