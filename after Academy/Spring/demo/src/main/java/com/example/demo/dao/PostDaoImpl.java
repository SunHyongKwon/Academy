package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.dto.PostDto;

public class PostDaoImpl implements PostDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.example.demo.dao.PostDao";

	@Override
	public List<PostDto> post() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".post");
	}

}
