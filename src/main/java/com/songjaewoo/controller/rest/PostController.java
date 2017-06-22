package com.songjaewoo.controller.rest;

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
import com.songjaewoo.model.dto.PostDto;
import com.songjaewoo.service.PostService;

@RestController
@RequestMapping(value = "/api")
public class PostController {

	@Autowired 
	private PostService postService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ResponseEntity<?> getPosts(@PageableDefault(sort = "createdDate", direction = Direction.DESC, size = 20) Pageable pageable) {
		
		Page<Post> getPosts = postService.getPosts(pageable);
		
		return new ResponseEntity<>(getPosts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{categoryId}/posts", method = RequestMethod.GET)
	public ResponseEntity<?> getCategoryPosts(@PathVariable Long categoryId,
										@PageableDefault(sort = "createdDate", direction = Direction.DESC, size = 20) Pageable pageable) {
		
		Page<Post> getCategoryPosts = postService.getCategoryPosts(categoryId, pageable);
		
		return new ResponseEntity<>(getCategoryPosts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPostById(@PathVariable Long id) {
		Post getPostById = postService.getPostById(id);
		
		return new ResponseEntity<>(getPostById, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<?> createPost(@RequestBody PostDto.Create postDto) {
		Post createPost = postService.createPost(postDto);
		
		return new ResponseEntity<>(createPost, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/post/{id}/update", method = RequestMethod.POST)
	public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostDto.Update postDto) {
		//TODO METHOD PUT으로 바꿔야함..
		Post updatePost = postService.updatePost(id, postDto);
		
		return new ResponseEntity<>(updatePost, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePost(@PathVariable Long id) {
		postService.deletePost(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
