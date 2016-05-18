package com.xyj.service.impl;
import java.util.List;
import java.util.UUID;

import com.xyj.commons.Page;
import com.xyj.dao.BookDao;
import com.xyj.dao.CategoryDao;
import com.xyj.dao.impl.BookDaoImpl;
import com.xyj.dao.impl.CategoryDaoImpl;
import com.xyj.domain.Book;
import com.xyj.domain.Category;
import com.xyj.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	CategoryDao dao = new CategoryDaoImpl();
	BookDao bdao = new BookDaoImpl();
	public void addCategory(Category category) {
		category.setId(UUID.randomUUID().toString());
		dao.save(category);
	}

	public List<Category> findAllCategory() {
		
		return dao.findAll();
	}


	public Category findCategoryById(String id) {
		return dao.findById(id);
	}
	
	public void addBook(Book book) {
		book.setId(UUID.randomUUID().toString());
		bdao.save(book);
		
	}

	public Page findPageBook(String pageNum) {
		int currentPageNum = 1;
		if(pageNum!=null){
			currentPageNum=Integer.parseInt(pageNum);
		}
		int totalRecords = bdao.findAllBooksNumber();
		Page page = new Page(totalRecords, currentPageNum);
		List<Book> lists = bdao.findPageBooks(page.getCurrentIndex(),page.getPageSize());
		page.setRecords(lists);
		return page;
	}


}
