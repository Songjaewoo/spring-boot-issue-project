package com.songjaewoo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.songjaewoo.model.Post;

public interface PostService {
	Page<Post> getPosts(Pageable pageable);
	Post getPostById(Long id);
	Post createPost(Post post);
	Post updatePost(Long id, Post post);
	void deletePost(Long id);
}
