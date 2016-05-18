package com.xyj.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xyj.dao.CategoryDao;
import com.xyj.domain.Category;
import com.xyj.exception.DaoException;
import com.xyj.util.DBCPUtil;

public class CategoryDaoImpl implements CategoryDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void save(Category category) {
		try {
			qr.update("insert into categorys (id,name,description) value(?,?,?)", 
					category.getId(),category.getName(),
					category.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public List<Category> findAll() {
		try {
			return qr.query("select * from categorys",
					new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
