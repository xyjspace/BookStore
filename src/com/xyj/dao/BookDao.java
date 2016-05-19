package com.xyj.dao;

import java.util.List;

import com.xyj.domain.Book;

public interface BookDao {

	void save(Book book);

	int findAllBooksNumber();

	List<Book> findPageBooks(int currentIndex, int pageSize);

	void delete(String bookId);

	int findBooksNumberByCategory(String category_id);

	List<Book> findPageBooks(int currentIndex, int pageSize, String category_id);

}
