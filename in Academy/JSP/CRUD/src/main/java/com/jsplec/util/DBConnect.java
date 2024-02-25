package com.jsplec.util;


public class DBConnect {
	// Database 환경 정의
	
	// jdbc : java databse connectivity / 3306 : port /schema 이름 / useSSL 찾아보자.	
	public final static String url_mysql = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE"; 
	
	// mysql 아이디 
	public final static String id_mysql = "root";
	
	// mysql 비밀번호
	public final static String pw_mysql = "tnstjd12";
	
	// 질문 : 이거 getter , setter 메소드로 바꾸고 private으로 쓰는게 더 좋지 않을지 궁금
	
}
