package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.example.demo.dao.UserDao";

	@Override
	public int loginCheck(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne( nameSpace + ".loginCheck" );
	}

}
