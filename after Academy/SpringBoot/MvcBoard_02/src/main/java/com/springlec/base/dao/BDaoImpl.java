package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.dto.BDto;

public class BDaoImpl implements BDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.BDao";

	@Override
	public List<BDto> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace +".list");
	}

	@Override
	public void write(String bName, String bContent) throws Exception {
		sqlSession.insert(nameSpace + ".write");
	}
	
	@Override
	public void delete(String bId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + ".delete");
	}

}
