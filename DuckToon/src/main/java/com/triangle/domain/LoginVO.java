package com.triangle.domain;

public class LoginVO {

	private String state;
	private String accessToken;
	private String mail;
	private String nickname;
	private String profileImage;
	private String gender;
	private String id;
	private String name;
	private String birthday;
	private String age;


	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "LoginVO [state=" + state + ", accessToken=" + accessToken + ", mail=" + mail + ", nickname=" + nickname
				+ ", profileImage=" + profileImage + ", gender=" + gender + ", id=" + id + ", name=" + name
				+ ", birthday=" + birthday + ", age=" + age + "]";
	}
}
