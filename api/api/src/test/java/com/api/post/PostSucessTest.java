package com.api.post;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.Application;
import com.api.TestUtils;
import com.api.model.entity.PostEntity;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class PostSucessTest extends TestUtils {
	
	@Test
	public void save() {
		PostEntity post = getPost("Title", "Description");
		postService.save(post);
		
		PostEntity postDb = postService.findById(post.getId());
		assertTrue(post.getId() == postDb.getId());
		
	}
	@Test
	public void list() {
		PostEntity post = getPost("Title", "Description");
		postService.save(post);
		
		PostEntity post2 = getPost("Title", "Description");
		postService.save(post2);
		
		List<PostEntity> posts = postService.findAll();
		
		assertTrue(posts.size() > 0);
	}
	
	@Test
	public void delete() {
		PostEntity post = getPost("Title", "Description");
		postService.save(post);
		
		PostEntity postDb = postService.findById(post.getId());
		if(null != post) {
			postService.removePost(postDb.getId());
		}
	}

}
