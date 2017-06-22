package com.songjaewoo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.songjaewoo.model.Category;
import com.songjaewoo.model.Post;
import com.songjaewoo.model.dto.PostDto;
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
	public Page<Post> getCategoryPosts(Long categoryId, Pageable pageable) {
		return postRepository.findByCategoryId(categoryId, pageable);
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findOne(id);
	}
	
	@Override
	public Post createPost(PostDto.Create postDto) {
		Post post = new Post();
		Category category = new Category();
		
		category.setId(postDto.getCategoryId());
		
		post.setTitle(postDto.getTitle());
		post.setWriter(postDto.getWriter());
		post.setDescription(postDto.getDescription());
		post.setCreatedDate(postDto.getCreatedDate());
		post.setUpdatedDate(postDto.getUpdatedDate());
		post.setCategory(category);
		
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(Long id, PostDto.Update postDto) {
		Post getPostById = getPostById(id);
		
		getPostById.setUpdatedDate(postDto.getUpdatedDate());
		getPostById.setTitle(postDto.getTitle());
		getPostById.setDescription(postDto.getDescription());
		
		return getPostById;
	}

	@Override
	public void deletePost(Long id) {
		postRepository.delete(id);
	}
}
