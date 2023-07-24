<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- format 라이브러리 쓰기 위해 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- attribute 로 생성이 되는 것 같다. -->
<c:set var="date" value="<%=new Date() %>" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사하기</title>
</head>
<body>
	
	서울 : <fmt:formatDate value="${date }" type="both" />
	
	<fmt:setTimeZone value="Europe/London"/>
	런던 : <fmt:formatDate value="${date }" type="both" />
	
	<fmt:setTimeZone value="America/New_York"/>
	뉴욕 : <fmt:formatDate value="${date }" type="both" />
</body>
</html>