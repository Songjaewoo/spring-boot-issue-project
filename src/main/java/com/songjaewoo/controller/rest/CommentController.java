package com.songjaewoo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.songjaewoo.model.Comment;
import com.songjaewoo.model.dto.CommentDto;
import com.songjaewoo.service.CommentService;

@RestController
@RequestMapping(value = "/api")
public class CommentController {

	@Autowired 
	private CommentService commentService;
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ResponseEntity<?> createComment(@RequestBody CommentDto.Create commentDto) {
		Comment createComment = commentService.createComment(commentDto);
		
		return new ResponseEntity<>(createComment, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/comment/{id}/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody CommentDto.Update commentDto) {
		//TODO METHOD PUT으로 바꿔야함..
		Comment updateComment = commentService.updateComment(id, commentDto);
		
		return new ResponseEntity<>(updateComment, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<?> deletePost(@PathVariable Long id) {
//		commentService.deletePost(id);
//		
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
}
