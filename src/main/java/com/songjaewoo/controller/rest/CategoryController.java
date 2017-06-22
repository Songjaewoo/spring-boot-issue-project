package com.songjaewoo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.songjaewoo.model.Category;
import com.songjaewoo.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
public class CategoryController {

	@Autowired 
	private CategoryService categoryService;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<?> getCategories() {
		
		List<Category> getCategories = categoryService.getCategories();
		
		return new ResponseEntity<>(getCategories, HttpStatus.OK);
	}
}
