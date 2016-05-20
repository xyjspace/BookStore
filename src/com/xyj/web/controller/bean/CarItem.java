package com.xyj.web.controller.bean;

import com.xyj.domain.Book;

public class CarItem {
	private Book book;
	public CarItem(Book book) {
		this.book = book;
	}
	private int totalNum;
	private float totalPrice;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public float getTotalPrice() {
		return totalNum*book.getPrice();
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
