package com.tutorial.web.dao;

import java.util.List;

import com.tutorial.web.entity.Reply;

public interface ReplyDao {
	
	int insert(Reply reply);
	
	int update(Reply reply);
	
	int delete(int id);
	
	Reply get(int id);
	
	List<Reply> getList();

}