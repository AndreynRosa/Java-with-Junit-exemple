package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.api.model.entity.PostEntity;
import com.api.services.PostService;

@RestController
@RequestMapping(value = "/v1/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public String test() {
		return "test";
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView createPost(@RequestBody PostEntity postEntity) {
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
		PostEntity post = new PostEntity();
		try {
			post = postService.save(postEntity);
			modelAndView.addObject("data", post);
			modelAndView.addObject("error", null);
			modelAndView.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			modelAndView.addObject("data", null);
			modelAndView.addObject("error", e);
			modelAndView.setStatus(HttpStatus.BAD_REQUEST);
		}

		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
		List<PostEntity> posts = new ArrayList<PostEntity>();
		try {
			posts = postService.findAll();
			modelAndView.addObject("data", posts);
			modelAndView.addObject("error", null);
			modelAndView.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			modelAndView.addObject("data", null);
			modelAndView.addObject("error", e);
			modelAndView.setStatus(HttpStatus.BAD_REQUEST);
		}

		return modelAndView;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json")
	public ModelAndView remove(@RequestParam Integer postId) {
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

		try {
			postService.removePost(postId);
			modelAndView.addObject("data", "post deleted");
			modelAndView.addObject("error", null);
			modelAndView.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			modelAndView.addObject("data", null);
			modelAndView.addObject("error", e);
			modelAndView.setStatus(HttpStatus.BAD_REQUEST);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/vote", method = RequestMethod.DELETE, produces = "application/json")
	public ModelAndView removeVote(@RequestParam Integer postId) {
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
		PostEntity post = postService.findById(postId);

		try {
			if (post.getUpVotes().size() == 0) {
				modelAndView.addObject("data", "não possui votos");
				modelAndView.addObject("error", null);
				modelAndView.setStatus(HttpStatus.OK);
			} else {
				postService.removeVote(postId);
				modelAndView.addObject("data", "remove 1 vote");
				modelAndView.addObject("error", null);
				modelAndView.setStatus(HttpStatus.OK);
			}

		} catch (Exception e) {
			modelAndView.addObject("data", null);
			modelAndView.addObject("error", e);
			modelAndView.setStatus(HttpStatus.BAD_REQUEST);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/vote", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView addVote(@RequestParam Integer postId) {
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

		try {
			postService.addVote(postId);
			modelAndView.addObject("data", "add 1 vote");
			modelAndView.addObject("error", null);
			modelAndView.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			modelAndView.addObject("data", null);
			modelAndView.addObject("error", e);
			modelAndView.setStatus(HttpStatus.BAD_REQUEST);
		}

		return modelAndView;
	}
}
