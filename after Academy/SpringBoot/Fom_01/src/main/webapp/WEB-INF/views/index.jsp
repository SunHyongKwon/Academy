<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function change(){
	document.soon.action = "/board/checkid";
	document.soon.submit();
}

function change2(){
	document.soon.action = "/board/join";
	document.soon.submit();
}

</script>

</head>
<body>
	<form action="/board/confirmid" name="soon" id="soon">
		<input type="text" name="id">
		<input type="text" name="name">
		<input type="text" name="email">
		<input type="text" name="error">
		<input type="submit" value="confirmid">
		<button type="button" onclick="change()">check id</button>
		<button type="button" onclick="change2()">join</button>
	</form>
</body>
</html>