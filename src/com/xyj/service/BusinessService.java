package com.xyj.service;

import java.util.List;

import com.xyj.domain.Category;

public interface BusinessService {
	/**
	 * ÃÌº”∑÷¿‡
	 * @param category
	 */
	void addCategory(Category category);
	
	List<Category> findAllCategory();
}
