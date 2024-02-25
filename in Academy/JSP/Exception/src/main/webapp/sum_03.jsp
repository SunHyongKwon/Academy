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
	
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int one = 0 , two = 0  , result = 0;
		
		try{
			
		one = Integer.parseInt(num1);
		two = Integer.parseInt(num2);
		
		result = one + two;
		
		}catch(NumberFormatException e){
			RequestDispatcher dispatcher = request.getRequestDispatcher("checkerror.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("http://localhost:8080/Exception/checkerror.jsp");
		}
		
		
	%>
	
	<%=one %> + <%=two %> = <%=result %>
</body>
</html>
