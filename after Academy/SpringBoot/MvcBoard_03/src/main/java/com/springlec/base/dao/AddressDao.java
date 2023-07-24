package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.dto.AddressDto;

public interface AddressDao {
	public List<AddressDto> list() throws Exception;
	public List<AddressDto> queryList(String query, String search) throws Exception;
}
