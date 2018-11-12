package com.znsd.client.page;
public class Pages<T>{
	private int currentIndexPage;//当前页数
	private int pageSize;//当前条数
	private int totalIndexPage;//总页数
	private int totalPageSize;//总条数
	public int getCurrentIndexPage() {
		return currentIndexPage;
	}
	public void setCurrentIndexPage(int currentIndexPage) {
		this.currentIndexPage = currentIndexPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalIndexPage() {
		return totalIndexPage;
	}
	public void setTotalIndexPage(int totalIndexPage) {
		this.totalIndexPage = totalIndexPage;
	}
	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	@Override
	public String toString() {
		return "Pages [currentIndexPage=" + currentIndexPage + ", pageSize=" + pageSize + ", totalIndexPage="
				+ totalIndexPage + ", totalPageSize=" + totalPageSize + "]";
	}
}