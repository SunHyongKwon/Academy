package com.springlec.base.service;

import java.util.List;

import com.springlec.base.dto.AddressDto;

public interface AddressService {
	public List<AddressDto> list() throws Exception;
	public List<AddressDto> queryList(String query, String search) throws Exception;
	
	
}
