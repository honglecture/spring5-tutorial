package com.tutorial.web.dao;

import java.util.List;

import com.tutorial.web.entity.Board;

public interface BoardDao {
	
	int insert(Board board);
	
	int update(Board board);
	
	int delete(int id);
	
	Board get(int id);
	
	List<Board> getList();

}
