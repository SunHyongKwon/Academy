package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.dto.MovieDto;

public class MovieDaoImpl implements MovieDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.MovieDao";

	@Override
	public List<MovieDto> list() throws Exception {
		return sqlSession.selectList(nameSpace + ".list");
	}

}
