package com.xyj.commons;

import java.util.List;


public class Page{
	private List records;
	private int currentPageNum;
	private int totalPageNum;
	private int pageSize = 3;//每页显示的条数
	private int prePageNum;//上一页
	private int nextPageNum;//下一页
	
	private int totalRecords;//总记录数
	private int currentIndex;//当前记录数
	
	private String url;
	public Page(int totalRecords, int currentPageNum) {
		this.totalRecords = totalRecords;
		this.currentPageNum = currentPageNum;
		
		totalPageNum = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
		currentIndex = (currentPageNum-1)*pageSize;
	}
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPrePageNum() {
		return currentPageNum-1>0?currentPageNum-1:1;
	}
	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}
	public int getNextPageNum() {
		return currentPageNum+1>totalPageNum?totalPageNum:currentPageNum+1;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
