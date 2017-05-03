package com.songjaewoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.songjaewoo.model.Post;
import com.songjaewoo.service.PostService;

@RestController
@RequestMapping(value = "/api")
public class PostController {

	@Autowired 
	private PostService postService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ResponseEntity<?> getPosts(@PageableDefault(sort = "createdDate", 
														direction = Direction.DESC, 
														size = 20) Pageable pageable) {
		Page<Post> getPosts = postService.getPosts(pageable);
		
		return new ResponseEntity<>(getPosts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPostById(@PathVariable Long id) {
		Post getPostById = postService.getPostById(id);
		
		return new ResponseEntity<>(getPostById, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<?> createPost(@RequestBody Post post) {
		Post createPost = postService.createPost(post);
		
		return new ResponseEntity<>(createPost, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Post post) {
		Post updatePost = postService.updatePost(id, post);
		
		return new ResponseEntity<>(updatePost, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePost(@PathVariable Long id) {
		postService.deletePost(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
