package com.songjaewoo.controller.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.songjaewoo.model.Post;
import com.songjaewoo.model.type.CategoryType;
import com.songjaewoo.service.PostService;

@Controller
public class IndexController {
	@Autowired 
	private PostService postService;
	
	@RequestMapping(value = {"/", "/{categoryType}"}, method = RequestMethod.GET)
	public String index(@PathVariable Optional<CategoryType> categoryType,
						@PageableDefault(sort = "createdDate", direction = Direction.DESC, size = 5) Pageable pageable,
						Model model) {
		
		Page<Post> posts = null;
		
		if (categoryType.isPresent()) {
			posts = postService.getCategoryPosts(Long.valueOf(categoryType.get().seq), pageable);
			
			model.addAttribute("categoryId", categoryType.get().seq);
		} else {
			posts = postService.getPosts(pageable);
		}
		
		model.addAttribute("posts", posts);
		
		return "index";
	}
	
	@RequestMapping(value = "/post/write", method = RequestMethod.GET)
	public String postWrite(@RequestParam(defaultValue = "1") Integer categoryId, 
							Model model) {

		model.addAttribute("categoryId", categoryId);
		
		return "write";
	}
	
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public String postDetail(@PathVariable Long postId,	Model model) {
		
		Post post = postService.getPostById(postId);
		
		model.addAttribute("post", post);
		
		return "detail";
	}
	
	@RequestMapping(value = "/post/{postId}/edit", method = RequestMethod.GET)
	public String postModify(@PathVariable Long postId,	Model model) {
		
		Post post = postService.getPostById(postId);
		
		model.addAttribute("post", post);
		
		return "edit";
	}
}
