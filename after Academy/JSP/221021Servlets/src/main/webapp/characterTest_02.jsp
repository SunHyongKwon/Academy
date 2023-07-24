<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "CharacterTest_02S" method = "get">
	<h2>성격 테스트</h2>
	${name} 님의 성격 테스트 결과
	<br>
	<br>
	${color}색을 좋아하는 당신의 좋아하는 동물은 ${animal} 이고 좋아하는 음식은 ${food} 입니다.
	<br>
	==========================================================================================
	<br>
	${result}
	<br>
	<input type = "submit" value = "파일 확인하기">
	</form>
</body>
</html>