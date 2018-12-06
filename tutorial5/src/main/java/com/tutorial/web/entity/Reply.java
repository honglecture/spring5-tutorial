package com.tutorial.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Reply {

	@Id
	@GeneratedValue (
		strategy=GenerationType.AUTO
		,generator="native" /*dbms의 자동증가 방식으로 설정하겠다=native, hibernate가 자동증가 시킨후에 db에 입력해줘라*/
	)/*mysql의 경우 default값이 자동으로 입력된다*/
	@GenericGenerator(
		name="native"
		,strategy="native"
	)
	private int id;
	private String content;
	
	@Column(insertable=false, updatable=false)
	private Date regDate;
	@Column(updatable=false)
	private String writerId;
	@Column(insertable=false, updatable=false)
	private int boardId;
	
	@ManyToOne
	@JoinColumn(name="boardId")
	private Board board; // 부모 엔티티 설정, 보드 엔티티에서 boardId get과 set을 쓴다.
	
	public Reply() {}

	public Reply(int id, String content, Date regDate, String writerId, int boardId, Board board) {
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.writerId = writerId;
		this.boardId = boardId;
		this.board = board;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}


	

}
