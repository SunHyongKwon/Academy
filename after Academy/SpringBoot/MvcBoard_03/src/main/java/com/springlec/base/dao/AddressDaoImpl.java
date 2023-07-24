package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.dto.AddressDto;


public class AddressDaoImpl implements AddressDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.AddressDao";
	
	@Override
	public List<AddressDto> list() throws Exception {
		
		return sqlSession.selectList(nameSpace + ".list");
	}
	
	@Override
	public List<AddressDto> queryList(String query, String search) throws Exception {
		
		
		List<AddressDto> list = sqlSession.selectList(nameSpace + ".queryList");
		
		return list;
	}

}
