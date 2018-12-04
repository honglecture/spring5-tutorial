package com.tutorial.web.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.tutorial.web.dao.MemberDao;
import com.tutorial.web.dao.MemberRoleDao;
import com.tutorial.web.entity.Member;
import com.tutorial.web.entity.MemberRole;

public class TutorialUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao;

	@Override
	public UserDetails loadUserByUsername(String username){
		
		Member member = memberDao.get(username);
		List<MemberRole> memberRoles =  memberRoleDao.getListByMemberId(username);
		UserBuilder builder = null;
		// 권한 목록을 문자열로 줘야 한다.
		// 격자형 데이터에서 한 줄만 빼야 한다.
		String[] authorities = memberRoles.stream().map(mr->mr.getRoleName()).toArray(String[]::new);
		builder = User.withUsername(username);
		builder.password(member.getPwd());
		builder.authorities(authorities); 
		return builder.build();
		
	}

}
