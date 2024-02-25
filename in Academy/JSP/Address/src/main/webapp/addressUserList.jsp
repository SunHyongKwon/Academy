<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function changeForm(){
		var form= document.addresslist;
		
		form.action = "search";
		form.submit();
	}

</script>
<body>
	<h3>고객 명단 리스트</h3>
	

	<form action="purchaseInsert_01.jsp" name ="addresslist">
	검색 선택 : 
		<select name = "query">
			<option value="name">이름</option>
			<option value="tel">전화번호</option>
			<option value="address" selected>주소</option>
			<option value="relation">관계</option>
		</select>
		<input type="text" name="content">
		<input type="button" value="검색" onclick="changeForm()">
		<table border="1">
			<tr>
				<th>Seq</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>전자우편</th>
				<th>관계</th>
			</tr>
			
			<c:forEach var="list" items="${userList}">
				<tr>
					<td><a href="select?seq=${list.seq}">${list.seq}</a></td>
					<td><c:out value="${list.name }"></c:out></td>
					<td><c:out value="${list.tel }"></c:out></td>
					<td><c:out value="${list.address }"></c:out></td>
					<td><c:out value="${list.email }"></c:out></td>
					<td><c:out value="${list.relation }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<br> <br> 
		<input type="submit" value="입력">
		<br>
		---------------------------------------------------------------------------------
		<br>
		총 인원은 ${size}명 입니다.
	</form>
</body>
</html>


