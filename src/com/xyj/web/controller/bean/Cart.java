package com.xyj.web.controller.bean;

import java.util.HashMap;
import java.util.Map;

import com.xyj.domain.Book;

public class Cart {
	private Map<String, CarItem> items = new HashMap<String, CarItem>();
	private float totalPrice;
	private int totalNum;
	public Map<String, CarItem> getItems() {
		return items;
	}
	public void setItems(Map<String, CarItem> items) {
		this.items = items;
	}
	public float getTotalPrice() {
		totalPrice = 0;
		for(Map.Entry<String, CarItem> item: items.entrySet()){
			totalPrice+=item.getValue().getTotalPrice();
		}
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalNum() {
		totalNum = 0;
		for(Map.Entry<String, CarItem> item: items.entrySet()){
			totalNum+=item.getValue().getTotalNum();
		}
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public void addBook(Book book){
		if(items.containsKey(book.getId())){
			CarItem c = items.get(book.getId());
			c.setTotalNum(c.getTotalNum()+1);
		}else{
			CarItem c = new CarItem(book);
			c.setTotalNum(1);
			items.put(book.getId(), c);
		}
	}
	
}
