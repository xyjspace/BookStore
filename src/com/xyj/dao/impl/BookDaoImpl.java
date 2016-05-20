package com.xyj.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xyj.dao.BookDao;
import com.xyj.domain.Book;
import com.xyj.exception.DaoException;
import com.xyj.util.DBCPUtil;

public class BookDaoImpl implements BookDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void save(Book book) {
		try {
			qr.update("insert into books (id,name,author,description,price,path,fileName,category_id) values(?,?,?,?,?,?,?,?)",
						book.getId(),
						book.getName(),
						book.getAuthor(),
						book.getDescription(),
						book.getPrice(),
						book.getPath(),
						book.getFilename(),
						book.getCategory_id()
					);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public int findAllBooksNumber() {
		try {
			Object object = (Long) qr.query("select count(*) from books", new ScalarHandler(1));
			Long num = (Long)object;
			return num.intValue();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	public List<Book> findPageBooks(int currentIndex, int pageSize) {
		try {
			return qr.query("select * from books limit ?,?", new BeanListHandler<Book>(Book.class), currentIndex,pageSize);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
	}

	@Override
	public void delete(String bookId) {
		try {
			qr.update("delete from books where id=?",bookId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public int findBooksNumberByCategory(String category_id) {
		try {
			Object object = (Long) qr.query("select count(*) from books where category_id=?", new ScalarHandler(1),category_id);
			Long num = (Long)object;
			return num.intValue();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Book> findPageBooks(int currentIndex, int pageSize, String category_id) {
		try {
			return qr.query("select * from books where category_id=? limit ?,?", new BeanListHandler<Book>(Book.class),category_id,currentIndex,pageSize);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Book findBookById(String bookId) {
		try {
			return qr.query("select * from books where id=?", new BeanHandler<Book>(Book.class) ,bookId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
