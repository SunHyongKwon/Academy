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
	<div class="container">

		<div class="row my-5"></div>
		<div class="row my-5"></div>
		<div class="row my-5"></div>
		<div class="row my-5"></div>
		
		<div class="row justify-content-center">
			<div class="col-2">
				${num1 }
			</div>
			<div class="col-2">
				+
			</div>
			<div class="col-2">
				${num2 }
			</div>
			<div class="col-2">
				=
			</div>
			<div class="col-2">
				${addition }
			</div>
		</div>
		<div class="row my-5"></div>
		<div class="row justify-content-center">
			<div class="col-2">
				${num1 }
			</div>
			<div class="col-2">
				-
			</div>
			<div class="col-2">
				${num2 }
			</div>
			<div class="col-2">
				=
			</div>
			<div class="col-2">
				${minus }
			</div>
		</div>
		<div class="row my-5"></div>
		<div class="row justify-content-center">
			<div class="col-2">
				${num1 }
			</div>
			<div class="col-2">
				*
			</div>
			<div class="col-2">
				${num2 }
			</div>
			<div class="col-2">
				=
			</div>
			<div class="col-2">
				${multi }
			</div>
		</div>
		<div class="row my-5"></div>
		<div class="row justify-content-center">
			<div class="col-2">
				${num1 }
			</div>
			<div class="col-2">
				/
			</div>
			<div class="col-2">
				${num2 }
			</div>
			<div class="col-2">
				=
			</div>
			<div class="col-2">
				${divide }
			</div>
		</div>
		
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>