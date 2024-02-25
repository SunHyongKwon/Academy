package com.springlec.base.service;

import java.util.List;

import com.springlec.base.dto.MovieDto;

public interface MovieService {
	public List<MovieDto> list() throws Exception;
}
