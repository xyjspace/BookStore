package com.xyj.service;

import java.util.List;

import com.xyj.commons.Page;
import com.xyj.domain.Book;
import com.xyj.domain.Category;

public interface BusinessService {
	/**
	 * ÃÌº”∑÷¿‡
	 * @param category
	 */
	void addCategory(Category category);
	
	List<Category> findAllCategory();
	
	Category findCategoryById(String id);
	
	void addBook(Book book);
	
	
	Page findPageBook(String pageNum);

	void deleteBook(String bookId);

	Page findPageBook(String pageNum, String category_id);

	void deleteCategory(String category_id);
	
}
