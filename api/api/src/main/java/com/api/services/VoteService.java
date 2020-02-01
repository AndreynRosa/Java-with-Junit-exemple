package com.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.dao.VoteDao;
import com.api.model.entity.VoteEntity;

@Service
public class VoteService {
	
	@Autowired
	VoteDao dao;

	public VoteEntity save(VoteEntity vote) {
		
		return dao.save(vote);
	}

}
