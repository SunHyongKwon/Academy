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

	<h1>MyBatis 주소록 조건 검색</h1>

	<form action="search">
		<select name="query">
			<option value="aName">이름</option>
			<option value="aPhone">전화번호</option>
			<option value="aAdress">주소</option>
			<option value="aRelation">관계</option>
		</select> <input type="text" name="search"> <input type="submit"
			value="검색">

	</form>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>번호</td>
			<td>주소</td>
			<td>전자우편</td>
			<td>관계</td>
		</tr>
		<c:forEach items="${list}" var="dto" varStatus="status">
			<tr>
				<td><a href="content_view?bId=${dto.aId}">${status.count }</a></td>
				<td>${dto.aName}</td>
				<td>${dto.aPhone}</td>
				<td>${dto.aAddress}</td>
				<td>${dto.aEmail}</td>
				<td>${dto.aRelation}</td>
				<td><a href="delete?bId=${dto.aId}">X</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view">글작성</a></td>
		</tr>
	</table>

	<h6>검색 결과는 ${list.size()} 명 입니다.</h6>
</body>
</html>