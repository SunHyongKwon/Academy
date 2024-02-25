package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.BDao;

@Service
public class BDaoServiceImpl02 implements BDaoService02 {
	
	@Autowired
	BDao dao;



	@Override
	public void writeDao(HttpServletRequest request) throws Exception {
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		 dao.writeDao(bName, bTitle, bContent);
		 
	}


	@Override
	public void modifyDao(HttpServletRequest request) throws Exception {
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		dao.modifyDao(bId, bName, bTitle, bContent);
	}

	@Override
	public void deleteDao(HttpServletRequest request) throws Exception {
		String bId = request.getParameter("bId");
		dao.deleteDao(bId);
	}

}
