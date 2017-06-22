package com.songjaewoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.songjaewoo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
