<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String sitename = request.getParameter("sitename");
		
		switch(sitename){
		case "네이버":
		case "naver":
			response.sendRedirect("https://www.naver.com");
			break;
		case "다음":
		case "daum":
			response.sendRedirect("https://www.daum.net");
			break;
		case "구글":
		case "google":
			response.sendRedirect("https://www.google.com");
			break;
		default:
			response.sendRedirect("https://www.yahoo.com");
				
		}
	%>

</body>
</html>