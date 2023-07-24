package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.dto.BDto;

public interface BDao {
	public List<BDto> list() throws Exception;
	public void write(String bName, String bContent) throws Exception;
	public void delete(String bId) throws Exception;
}
