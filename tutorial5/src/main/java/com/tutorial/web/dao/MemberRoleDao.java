package com.tutorial.web.dao;

import java.util.List;

import com.tutorial.web.entity.MemberRole;

public interface MemberRoleDao {
	
	List<MemberRole> getListByMemberId(String memberId);

}
