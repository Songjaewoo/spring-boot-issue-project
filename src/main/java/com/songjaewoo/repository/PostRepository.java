package com.songjaewoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.songjaewoo.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
}
