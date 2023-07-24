package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.BDto;

public interface BDao {
	
	public List<BDto> listDao() throws Exception;
	public void writeDao(String bName, String bTitle, String bContent) throws Exception;
	public void modifyDao(String bId ,String bName, String bTitle, String bContent) throws Exception;
	public void deleteDao(String bId) throws Exception;
	public BDto selectBoard(String bId) throws Exception;
	
}
