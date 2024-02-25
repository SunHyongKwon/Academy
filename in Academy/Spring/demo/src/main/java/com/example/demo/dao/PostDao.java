package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.PostDto;

public interface PostDao {
	public List<PostDto> post() throws Exception;
	
}
