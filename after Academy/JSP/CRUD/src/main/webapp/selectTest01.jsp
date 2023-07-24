<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스에서 불러오기</title>
</head>
<body>
	<h3>고객 명단 불러오기</h3>
	<table border ="1">
		<tr>
			<th>번호</th>
			<th>User ID</th>
		</tr>
		<c:forEach var="list" items="${idList}" > 
			<tr>
				<th> <c:out value="${list.id }"></c:out> <th>
				<th> <c:out value="${list.userid }"></c:out> <th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>