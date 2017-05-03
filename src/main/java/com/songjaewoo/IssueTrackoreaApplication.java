package com.songjaewoo;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.songjaewoo.model.Post;
import com.songjaewoo.service.PostService;

@SpringBootApplication
public class IssueTrackoreaApplication {

	@Autowired 
	private PostService postService;
	
	public static void main(String[] args) {
		SpringApplication.run(IssueTrackoreaApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		for (int i=0; i<10; i++) {
			Post post = new Post();
			post.setTitle("title" + i);
			post.setDescription("descrition" + i);
			post.setWriter("writer" + i);
			post.setCreatedDate(new Date());
			post.setUpdatedDate(new Date());
			
			postService.createPost(post);
		}
		
	}
}
