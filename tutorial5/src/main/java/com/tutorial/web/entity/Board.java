package com.tutorial.web.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Board {
	/*
	 * dbms의 자동증가 방식으로 설정하겠다=native, hibernate가
	 * 자동증가 시킨후에 db에 입력해줘라
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native") /* mysql의 경우 default값이 자동으로 입력된다 */
	@GenericGenerator(name = "native", strategy = "native")
	private int id;

	private String title;
	private String content;

	@Column(insertable = false, updatable = false)
	private Date regDate;
	@Column(updatable = false)
	private String writerId;

	@OneToMany(mappedBy = "boardId", fetch = FetchType.EAGER)
	private List<Reply> replys;

	public Board() {
	}

	public Board(int id, String title, String content, Date regDate, String writerId, List<Reply> replys) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.writerId = writerId;
		this.replys = replys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

}
