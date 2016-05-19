package com.xyj.dao;

import java.util.List;

import com.xyj.domain.Category;

public interface CategoryDao {

	void save(Category category);

	List<Category> findAll();

	Category findById(String id);

	void delete(String category_id);

}
