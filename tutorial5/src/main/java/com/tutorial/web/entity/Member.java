package com.tutorial.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	private String id;

	private String email;
	private String password;
	private String nickname;
	@Column(insertable=false, updatable=false)
	private Date regDate;
	@Column(columnDefinition="default")
	private String photo;

	public Member() {
	}

	public Member(String id, String email, String password, String nickname, Date regDate, String photo) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.regDate = regDate;
		this.photo = photo;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}