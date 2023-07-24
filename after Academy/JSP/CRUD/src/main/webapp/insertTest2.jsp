<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>

<%
	String id = request.getParameter("id");	

	String url_mysql = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	PreparedStatement ps = null;
	int i = 0;
	String result = "";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); // package 이름과 class 이름을 정해준 것이다.
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
		
		String query = "insert into new_table (userid) ";
		String query1 = "values (?)";

		ps = conn_mysql.prepareStatement(query + query1);
		ps.setString(1, id);
		
		
		i = ps.executeUpdate(); 
		
		result = "DB에 데이터 넣음";
		
		conn_mysql.close();

	} catch (Exception e) {
		e.printStackTrace();
		result = "DB에 데이터 안들어감";
	}
	
	request.setAttribute("insert", i);
	request.setAttribute("result", result);
	RequestDispatcher dispatcher = request.getRequestDispatcher("insertTest3.jsp");
	dispatcher.forward(request, response);
%>


