package com.xyj.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.xyj.domain.Category;
import com.xyj.service.BusinessService;
import com.xyj.service.impl.BusinessServiceImpl;
import com.xyj.util.FileBeanUtil;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessService bs = new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("addCategory".equals(op)){
			addCategoty(request,response);
		}if("showAllCategory".equals(op)){
			showAllCategory(request,response);
		}
	}

	private void showAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> lists = bs.findAllCategory();
		
		request.setAttribute("lists", lists);
		request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);
		
	}

	private void addCategoty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = FileBeanUtil.fillBean(request, Category.class);
		bs.addCategory(c);
		
		request.setAttribute("msg", "±£´æ³É¹¦!");
		request.getRequestDispatcher("/manager/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
