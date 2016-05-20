package com.xyj.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyj.commons.Page;
import com.xyj.domain.Book;
import com.xyj.domain.Category;
import com.xyj.service.BusinessService;
import com.xyj.service.impl.BusinessServiceImpl;
import com.xyj.web.controller.bean.CarItem;
import com.xyj.web.controller.bean.Cart;

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BusinessService bs = new BusinessServiceImpl();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("showAllBook".equals(op)){
			showAllBook(request,response);
		}if("showCategoryBook".equals(op)){
			showCategoryBook(request,response);
		}if("showThisBook".equals(op)){
			showThisBook(request,response);
		}if("buyBook".equals(op)){
			buyBook(request,response);
		}if("deleteOneItem".equals(op)){
			deleteOneItem(request,response);
		}if("changeNum".equals(op)){
			changeNum(request,response);
		}
	
	}

	private void changeNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bookId = request.getParameter("bookId");
		String num = request.getParameter("num");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		CarItem c = cart.getItems().get(bookId);
		c.setTotalNum(Integer.parseInt(num));
		response.sendRedirect(request.getContextPath()+"/client/showCart.jsp");
	}

	private void deleteOneItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bookId = request.getParameter("bookId");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.getItems().remove(bookId);
		response.sendRedirect(request.getContextPath()+"/client/showCart.jsp");
	}

	private void buyBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Book book = bs.findBookById(bookId);
		HttpSession session = request.getSession();
		//从对话中获得cart如果为空就证明没有购物车,这样可以保证在一次会话中只有一个购物车。
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addBook(book);
		
		request.setAttribute("msg", "书籍已经放入您的购物车，<a href='"+request.getContextPath()+"'>继续购物</a>");
		request.getRequestDispatcher("/client/message.jsp").forward(request, response);
	}


	private void showThisBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Book book = bs.findBookById(bookId);
		
		request.setAttribute("book", book);
		request.getRequestDispatcher("/client/showBook.jsp").forward(request, response);
		
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
