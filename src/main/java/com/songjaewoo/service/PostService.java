package com.songjaewoo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.songjaewoo.model.Post;
import com.songjaewoo.model.dto.PostDto;

public interface PostService {
	Page<Post> getPosts(Pageable pageable);
	Page<Post> getCategoryPosts(Long categoryId, Pageable pageable);
	Post getPostById(Long id);
	Post createPost(PostDto.Create postDto);
	Post updatePost(Long id, PostDto.Update postDto);
	void deletePost(Long id);
}
