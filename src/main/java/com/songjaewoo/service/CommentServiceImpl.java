package com.songjaewoo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songjaewoo.model.Comment;
import com.songjaewoo.model.dto.CommentDto;
import com.songjaewoo.repository.CommentRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired 
	private CommentRepository commentRepository;

	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.findOne(id);
	}
	
	@Override
	public Comment createComment(CommentDto.Create commentDto) {
		Comment comment = new Comment();
		
		comment.setPostId(commentDto.getPostId());
		comment.setWriter(commentDto.getWriter());
		comment.setDescription(commentDto.getDescription());
		comment.setPassword(commentDto.getPassword());
		comment.setCreatedDate(commentDto.getCreatedDate());
		comment.setUpdatedDate(commentDto.getUpdatedDate());
		
		return commentRepository.save(comment);
	}

	@Override
	public Comment updateComment(Long id, CommentDto.Update commentDto) {
		Comment getCommentById = getCommentById(id);
		
		getCommentById.setDescription(commentDto.getDescription());
		getCommentById.setUpdatedDate(commentDto.getUpdatedDate());
		
		return commentRepository.save(getCommentById);
	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.delete(id);
	}
}
