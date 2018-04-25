package com.triangle.domain;

public class RelationshipVO {

	private int num;
	private String userId;
	private String webtoonId;
	private int rating = 0;
	private String review;
	private String episode;
	private String viewTime;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	public String getViewTime() {
		return viewTime;
	}
	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}
	
}
