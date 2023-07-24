<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>고객 명단 리스트</h3>
	<table border ="1">
		<tr>
			<th>UserID</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>입력일자</th>
		</tr>
		
		<c:forEach var="list" items="${userList}" >
			<tr>
				<td> <a href= "select3?id=${list.userid}">${list.userid }</a> </td>
				<td> <c:out value="${list.name }"></c:out> </td>
				<td> <c:out value="${list.tel }"></c:out> </td>
				<td> <c:out value="${list.address }"></c:out> </td>
				<td> <c:out value="${list.insertdate }"></c:out> </td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	
	총 인원은 ${size}명 입니다. 
</body>
</html>


