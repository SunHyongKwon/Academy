<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

</head>
<body>
	<form action="calc">
		<div class="container">

			<div class="row my-5"></div>
			<div class="row my-5"></div>
			<div class="row my-5"></div>
			<div class="row my-5"></div>
			<div class="row justify-content-center">
				<div class="col-4">
					<label for="num1">1번 숫자</label> <input type="text" name="num1">
				</div>
				<div class="col-4">
					<label for="num1">2번 숫자</label> <input type="text" name="num2">
				</div>
			</div>

			<div class="row my-5"></div>
			<div class="row my-5"></div>
			<div class="row justify-content-center">
				<div class="col-6">
					<input type="submit" class="btn btn-primary" value="계산">
				</div>
			</div>
		</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>