<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>MyBatis 영화 검색</h1>



	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>이미지</td>
			<td>영화</td>
		</tr>
		<c:forEach items="${list}" var="dto" varStatus="status">
			<tr>
				<td><img src="${dto.image }"></td>
				<td>${dto.title}</td>
				
			</tr>
		</c:forEach>
	</table>

	<h6>검색 결과는 ${list.size()} 명 입니다.</h6>
</body>
</html>