<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- format 라이브러리 쓰기 위해 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사하기</title>
</head>
<body>
	<!-- 숫자를 천단위씩 끊어서 알려준다.  -->
	<fmt:formatNumber value="1234500" groupingUse="true" /> <br>
	<fmt:formatNumber value="3.141592" pattern="#.##" />	<br>
	<fmt:formatNumber value="10.5" pattern="#.00" />	<br>
</body>
</html>