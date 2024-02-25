package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AddressDao;
import com.springlec.base.dto.AddressDto;

@Service
public class AddressServcieImpl implements AddressService {

	@Autowired
	AddressDao dao;
	
	@Override
	public List<AddressDto> list() throws Exception {
		
		List<AddressDto> list = dao.list();
		
		return list;
	}
	
	@Override
	public List<AddressDto> queryList(String query, String search) throws Exception {
		List<AddressDto> list = dao.queryList(query, search);
		
		return list;
	}

}
