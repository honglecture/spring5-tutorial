package com.tutorial.web.service.hibernate;

import org.springframework.stereotype.Service;

import com.tutorial.web.service.HomeService;
@Service
public class HibernateHomeService implements HomeService {

	@Override
	public String getDefaultRoleName(String memberId) {
		return null;
	}

}
