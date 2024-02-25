package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.MovieDao;
import com.springlec.base.dto.MovieDto;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieDao dao;

	@Override
	public List<MovieDto> list() throws Exception {
		return dao.list();
	}

}
