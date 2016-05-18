package com.xyj.service.impl;
import java.util.List;
import java.util.UUID;

import com.xyj.dao.CategoryDao;
import com.xyj.dao.impl.CategoryDaoImpl;
import com.xyj.domain.Category;
import com.xyj.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	CategoryDao dao = new CategoryDaoImpl();
	
	public void addCategory(Category category) {
		category.setId(UUID.randomUUID().toString());
		dao.save(category);
	}

	public List<Category> findAllCategory() {
		
		return dao.findAll();
	}

}
