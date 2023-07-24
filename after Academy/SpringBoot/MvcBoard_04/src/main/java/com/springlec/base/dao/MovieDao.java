package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.dto.MovieDto;

public interface MovieDao {
	public List<MovieDto> list() throws Exception;
}
