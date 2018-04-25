package com.triangle.domain;

public class Criteria {
	
	private int num;
	private int startNo;
	private int endNo;
	private int currentPage;
	private String userId;
	private String webtoonId;
	
	public Criteria(int currentPage, int num){
		if(currentPage<1) currentPage = 1;
		this.currentPage = currentPage;
		this.num = num;
		startNo = (currentPage-1) * num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWebtoonId() {
		return webtoonId;
	}

	public void setWebtoonId(String webtoonId) {
		this.webtoonId = webtoonId;
	}
	
	
}
