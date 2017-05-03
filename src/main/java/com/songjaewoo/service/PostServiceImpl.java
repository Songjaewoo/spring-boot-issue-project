package com.songjaewoo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.songjaewoo.model.Post;
import com.songjaewoo.repository.PostRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	@Autowired 
	private PostRepository postRepository;

	@Override
	public Page<Post> getPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findOne(id);
	}
	
	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(Long id, Post post) {
		Post getPostById = getPostById(id);
		
		getPostById.setTitle(post.getTitle());
		getPostById.setDescription(post.getDescription());
		
		return getPostById;
	}

	@Override
	public void deletePost(Long id) {
		postRepository.delete(id);
	}
}
