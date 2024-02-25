package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.BDto;

public class BDaoImpl implements BDao {
	
	// 얘가 BDao.xml 과 연결시켜준다. 
	SqlSession sqlSession;
	
	// 코딩하기 편하게 하기 위해서 static으로 하나 준다. 
	public static String nameSpace = "com.springlec.base.dao.BDao";

	@Override
	public List<BDto> listDao() throws Exception {
		
		// sqlSession으로 BDao.xml에서 nameSpace에서의 뒤에 오는 변수명의 id를 가져와서 리스트로 만든다는 것이다.
		// 만약 내가 받고 싶은 값이 list가 아니라면 select를 사용하면 되고 , 그 외는 찾아봐야 될 것 같다.
		return sqlSession.selectList(nameSpace + ".listDao");
	}

	@Override
	public void writeDao(String bName, String bTitle, String bContent) throws Exception {
		
		sqlSession.insert(nameSpace + ".writeDao");
		
	}

	@Override
	public BDto selectBoard(String bId) throws Exception {
		
		
		return sqlSession.selectOne(nameSpace + ".selectBoard" , bId);
	}

	@Override
	public void modifyDao(String bId, String bName, String bTitle, String bContent) throws Exception {
		
		sqlSession.update(nameSpace + ".modifyDao");
		
	}

	@Override
	public void deleteDao(String bId) throws Exception {
		
		sqlSession.delete(nameSpace + ".deleteDao");
		
	}

}
