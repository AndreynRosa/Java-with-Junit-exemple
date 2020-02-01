package com.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.dao.PostDao;
import com.api.model.entity.PostEntity;
import com.api.model.entity.VoteEntity;


@Service
public class PostService {

	@Autowired
	PostDao dao;

	public String test() {
		return "andrey";
	}

	public PostEntity save(PostEntity post) {
	return	 dao.save(post);
//		 List<VoteEntity> votes 

	}

	public PostEntity findById(Integer id) {
		Optional<PostEntity> opt = dao.findById(id);
		return opt.orElse(null);
	}



	public List<PostEntity> findAll() {
		return dao.findAll();
	}

	public void removeVote(Integer postId) {
		PostEntity post = findById(postId);
		post.getUpVotes().remove(0);
		dao.save(post);
	}

	public void removePost(Integer id) {
		dao.deleteById(id);
		
	}

	public void addVote(Integer postId) {
		PostEntity post = findById(postId);
		VoteEntity vote = new VoteEntity();
		vote.setVoteDate(new Date());
		post.getUpVotes().add(vote);
		save(post);
	}

	
}
