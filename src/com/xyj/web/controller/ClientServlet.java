package com.xyj.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyj.commons.Page;
import com.xyj.domain.Category;
import com.xyj.service.BusinessService;
import com.xyj.service.impl.BusinessServiceImpl;

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BusinessService bs = new BusinessServiceImpl();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("showAllBook".equals(op)){
			showAllBook(request,response);
		}if("showCategoryBook".equals(op)){
			showCategoryBook(request,response);
		}
	
	}

	private void showCategoryBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		
		String category_id = request.getParameter("categoryId");
		List<Category> lists = bs.findAllCategory();
		Page page = bs.findPageBook(pageNum,category_id);
		page.setUrl("/servlet/ClientServlet?op=showCategoryBook&categoryId="+category_id);
		request.setAttribute("page",page);
		request.setAttribute("lists", lists);
		request.getRequestDispatcher("/client/listBook.jsp").forward(request, response);
	}

	private void showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		Page page = bs.findPageBook(pageNum);
		page.setUrl("/servlet/ClientServlet?op=showAllBook");
		List<Category> lists = bs.findAllCategory();
		
		request.setAttribute("page",page);
		request.setAttribute("lists", lists);
		
		request.getRequestDispatcher("/client/listBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
