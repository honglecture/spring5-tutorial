package com.tutorial.web.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.tutorial.web.entity.Member;

public interface MemberService {

	int insertMember(Member member);

	String insertProfilePhoto(String id, MultipartFile photo, HttpServletRequest request) throws IOException;

	Member getMember(String memberId);


}
