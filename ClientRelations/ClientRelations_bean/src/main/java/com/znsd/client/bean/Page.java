package com.znsd.client.bean;

public class Page {
	//当前页数
	private int currentPage;
	
	//每页显示数据个数
	private int pageSize;
	
	//总条数
	private int total;

	//总页数
	private int totalPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
}
