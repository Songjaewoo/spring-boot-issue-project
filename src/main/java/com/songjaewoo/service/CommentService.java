package com.songjaewoo.service;

import com.songjaewoo.model.Comment;
import com.songjaewoo.model.dto.CommentDto;

public interface CommentService {
	Comment getCommentById(Long id);
	
	Comment createComment(CommentDto.Create commentDto);
	
	Comment updateComment(Long id, CommentDto.Update commentDto);
	
	void deleteComment(Long id);
}
