package com.example.demo.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.dao.PostDao;
import com.example.demo.dto.PostDto;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostDao postDao;
	
	@Override
	public void post(Model model) throws Exception {
		
		// TODO Auto-generated method stub
		List<PostDto> result = postDao.post();
		
		JSONObject jsonList = new JSONObject();
	    JSONArray itemList = new JSONArray();
	    
	    
	    for(PostDto a : result) {
	    	JSONObject tempJson = new JSONObject();
            tempJson.put("title", a.getTitle());
            itemList.add(tempJson);
	    }
	    
	    jsonList.put("results",itemList);
		
		model.addAttribute("result", jsonList);
	}
}
