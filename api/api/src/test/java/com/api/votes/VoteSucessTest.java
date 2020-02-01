package com.api.votes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.Application;
import com.api.TestUtils;
import com.api.model.entity.PostEntity;
import com.api.model.entity.VoteEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class VoteSucessTest extends TestUtils {

	@Test
	public void save() {

		VoteEntity vote = createVote();
		assertNotNull(vote.getId());
	}

	private VoteEntity createVote() {
		Date date = new Date();
		VoteEntity vote = getVote(date);
		voteService.save(vote);
		return vote;
	}

	@Test
	public void doVote() {
		VoteEntity vote = createVote();
		
		PostEntity post = getPost("Vote test Sucess", "Be Ok");
		postService.save(post);
		postService.addVote(post.getId());
		PostEntity postDb = postService.findById(post.getId());
		assertNotNull(vote.getId().equals(postDb.getUpVotes().get(0).getId()));
	}

	@Test
	public void delete() {
		VoteEntity vote = createVote();
		
		PostEntity post = getPost("Vote test Sucess", "Be Ok");
		postService.save(post);


		post.getUpVotes().add(vote);
		postService.save(post);
		
		PostEntity postDb =  postService.findById(post.getId());
		if (null != postDb.getUpVotes().get(0)) {
			postService.removeVote( postDb.getId());

		}
		PostEntity removeVotesPost = new PostEntity();
		removeVotesPost =  postService.findById(post.getId());
		postService.save(removeVotesPost);
		assertTrue(removeVotesPost.getUpVotes() != postDb.getUpVotes() );
	}
}
