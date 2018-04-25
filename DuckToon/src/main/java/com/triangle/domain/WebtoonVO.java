package com.triangle.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebtoonVO {

	private String userId;
	private String webtoonId;
	private String webtoonName;
	private String webtoonThumbnail;
	private String webtoonIntroduce;
	private int isNew;
	private Date lastDate;
	private String day;
	private String genre;
	private String platform;
	private String writer;
	private String myThumbnail;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMyThumbnail() {
		return myThumbnail;
	}
	public void setMyThumbnail(String myThumbnail) {
		this.myThumbnail = myThumbnail;
	}
	public String getWebtoonId() {
		return webtoonId;
	}
	public void setWebtoonId(String webtoonId) {
		this.webtoonId = webtoonId;
	}
	public String getWebtoonName() {
		return webtoonName;
	}
	public void setWebtoonName(String webtoonName) {
		this.webtoonName = webtoonName;
	}
	public String getWebtoonThumbnail() {
		return webtoonThumbnail;
	}
	public void setWebtoonThumbnail(String webtoonThumbnail) {
		this.webtoonThumbnail = webtoonThumbnail;
	}
	public String getWebtoonIntroduce() {
		return webtoonIntroduce;
	}
	public void setWebtoonIntroduce(String webtoonIntroduce) {
		this.webtoonIntroduce = webtoonIntroduce;
	}
	public int getIsNew() {
		return isNew;
	}
	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}
	public String getLastDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(lastDate);
		return time;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
