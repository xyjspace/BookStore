package com.xyj.commons;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xyj.domain.Category;
import com.xyj.service.BusinessService;
import com.xyj.service.impl.BusinessServiceImpl;

public class MyFunctions extends SimpleTagSupport{
	private static BusinessService bs = new BusinessServiceImpl();
	public static String showCategoryName(String category_id){
		Category c = bs.findCategoryById(category_id);
		
		if(c!=null){
			return c.getName();
		}
		
		return null;
	}
}
