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
	<fmt:setLocale value="ko_kr"/>

	금액 : <fmt:formatNumber value="1000000" type="currency" /> <br>
	일시 : <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full" />
	<br>
	===========================================================
	<br>
	<fmt:setLocale value="en_us"/>
	금액 : <fmt:formatNumber value="1000000" type="currency" /> <br>
	일시 : <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full" />
	<br>
	===========================================================
	<br>
	<fmt:setLocale value="ja_jp"/>
	금액 : <fmt:formatNumber value="1000000" type="currency" /> <br>
	일시 : <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full" />
	<br>
	===========================================================
	<br>
	<fmt:setLocale value="zh_cn"/>
	금액 : <fmt:formatNumber value="1000000" type="currency" /> <br>
	일시 : <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full" />
</body>
</html>