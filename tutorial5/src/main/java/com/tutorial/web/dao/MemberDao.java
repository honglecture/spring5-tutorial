package com.tutorial.web.dao;

import java.util.List;

import com.tutorial.web.entity.Member;

public interface MemberDao {
	
	int insert(Member member);
	
	int update(Member member);
	
	int delete(String id);
	
	Member get(String memberId);
	
	List<Member> getList();

}