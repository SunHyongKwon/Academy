package com.jsplec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jsplec.bean.Member;
import com.jsplec.util.DBConnect;

public class DaoPurcahseinfo {
	private String userid;
	private String beforeid;
	private String name;
	private String tel;
	private String address;
	
	
	public DaoPurcahseinfo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DaoPurcahseinfo(String userid) {
		super();
		this.userid = userid;
	}



	public DaoPurcahseinfo(String userid, String name, String tel, String address) {
		super();
		this.userid = userid;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public DaoPurcahseinfo(String userid, String beforeid, String name, String tel, String address) {
		super();
		this.userid = userid;
		this.beforeid = beforeid;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public boolean insertAction() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 

			String query = "insert into purchaseinfo (userid,name,tel,address,insertdate) ";
			String query1 = "values (?,?,?,?,curdate())";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1,userid);
			ps.setString(2,name);
			ps.setString(3,tel);
			ps.setString(4,address);


			ps.executeUpdate(); 

			conn_mysql.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
		return true;
	}
	
	public boolean updateAction() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 

			String query = "update purchaseinfo set userid = ? , name = ? , tel = ? , address = ? where userid = ?" ;
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1,userid);
			ps.setString(2,name);
			ps.setString(3,tel);
			ps.setString(4,address);
			ps.setString(5,beforeid);


			ps.executeUpdate(); 

			conn_mysql.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
		return true;
	}
	
	public boolean deleteAction() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 

			String query = "delete from purchaseinfo where userid = ?" ;
			System.out.println(userid);
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1,userid);

			ps.executeUpdate(); 

			conn_mysql.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
		return true;
	}
	
	public Member selectAction() {
		String whereStatement = "select userid, name, tel, address from purchaseinfo where userid = '"+ userid+"'";
		Member model = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				model = new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		
		return model;
	}
	
	
}
