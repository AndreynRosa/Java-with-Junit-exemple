package com.api;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.model.entity.PostEntity;
import com.api.model.entity.VoteEntity;
import com.api.services.PostService;
import com.api.services.VoteService;

import junit.framework.TestCase;




public class TestUtils extends TestCase{
	
	

	@Autowired
	protected PostService postService;

	@Autowired
	protected VoteService voteService;
	
	
	protected  PostEntity  getPost (String title,String description) {
		PostEntity post = new PostEntity();
		post.setDescription(description);
		post.setTitle(title);
		return post;
	}
	
	protected  VoteEntity  getVote (Date date) {
		VoteEntity vote = new VoteEntity();
		vote.setVoteDate(date);
		return vote;
		
	}

}
