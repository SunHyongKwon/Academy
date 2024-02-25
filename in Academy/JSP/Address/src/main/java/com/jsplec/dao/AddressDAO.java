package com.jsplec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.jsplec.bean.Member;
import com.jsplec.util.DBConnect;

public class AddressDAO {
	private int seq;
	private String name;
	private String tel;
	private String address;
	private String email;
	private String relation;
	
	private String queryName;
	private String queryContent;
	
	public AddressDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public AddressDAO(int seq) {
		this.seq = seq;
	}
	

	public AddressDAO(int seq, String name, String tel, String address, String email, String relation) {
		this.seq = seq;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}

	public AddressDAO(String name, String tel, String address, String email, String relation) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}

	public AddressDAO(String queryName, String queryContent) {
		this.queryName = queryName;
		this.queryContent = queryContent;
	}

	public boolean insertAction() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 

			String query = "insert into user (name,tel,address,email,relation) ";
			String query1 = "values (?,?,?,?,?)";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1,name);
			ps.setString(2,tel);
			ps.setString(3,address);
			ps.setString(4,email);
			ps.setString(5,relation);


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

			String query = "update user set seq = ? , name = ? , tel = ? , address = ? , email = ? , relation = ?  where seq = ?" ;
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1,seq);
			ps.setString(2,name);
			ps.setString(3,tel);
			ps.setString(4,address);
			ps.setString(5,email);
			ps.setString(6,relation);
			ps.setInt(7,seq);


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

			String query = "delete from user where seq = ?" ;
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1,seq);

			ps.executeUpdate(); 

			conn_mysql.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
		return true;
	}
	
	public Member selectAction() {
		String whereStatement = "select seq, name, tel, address, email, relation from user where seq = "+seq;
		Member model = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {
				model = new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		
		return model;
	}
	
	public ArrayList<Member> selectQueryAction(){
		String whereStatement = "select seq, name, tel, address, email, relation from user where " 
					+ queryName + " like '%" + queryContent + "%'";
		ArrayList<Member> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while(rs.next()) {
				Member model = new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(model);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		
		return list;
	}
	
	public ArrayList<Member> selectAllAction() {
		String whereStatement = "select seq, name, tel, address, email, relation from user";
		ArrayList<Member> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while(rs.next()) {
				Member model = new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(model);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		
		return list;
	}
}
