package com.songjaewoo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songjaewoo.model.Category;
import com.songjaewoo.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
}
