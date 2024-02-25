package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.BDao;
import com.springlec.base.dto.BDto;

@Service
public class BDaoServiceImpl implements BDaoService {
	
	@Autowired
	BDao dao;

	@Override
	public List<BDto> list() throws Exception {
		
		return dao.list();
	}

	@Override
	public void write(String bName, String bContent) throws Exception {
		// TODO Auto-generated method stub
		dao.write(bName, bContent);
	}

	@Override
	public void delete(String bId) throws Exception {
		
		dao.delete(bId);
	}

}
