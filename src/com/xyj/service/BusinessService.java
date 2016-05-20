package com.xyj.service;

import java.util.List;

import com.xyj.commons.Page;
import com.xyj.domain.Book;
import com.xyj.domain.Category;

public interface BusinessService {
	/**
	 * 添加分类
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
	
	/**
	 * 根据书的ID查询图书
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
}
