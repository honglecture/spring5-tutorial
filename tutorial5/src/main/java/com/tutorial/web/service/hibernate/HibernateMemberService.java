package com.tutorial.web.service.hibernate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.web.dao.MemberDao;
import com.tutorial.web.dao.MemberRoleDao;
import com.tutorial.web.entity.Member;
import com.tutorial.web.entity.MemberRole;
import com.tutorial.web.service.MemberService;

@Service
public class HibernateMemberService implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao; 

	@Override
	public int insertMember(Member member) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(member.getPassword());
		member.setPassword(encodedPwd);
		int memberResult = memberDao.insert(member);
		int memberRoleResult = memberRoleDao.insert(new MemberRole("ROLE_CLIENT", member.getId(), true));
		return memberRoleResult;
	}

	@Override
	public String insertProfilePhoto(String id, MultipartFile photoFile, HttpServletRequest request) throws IOException {
		// 사진 저장 path 찾기
		String resLocation = "/resources/members/" + id + "/";
		ServletContext context = request.getServletContext();
		String homeDir = context.getRealPath(resLocation);
		String uploadedFileName = photoFile.getOriginalFilename();
		String filePath = homeDir + uploadedFileName;
		// 사진 저장
		File dir = new File(homeDir);
		if (!dir.exists())
			dir.mkdirs();
		InputStream fis = photoFile.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		byte[] buf = new byte[1024];
		int size = 0;
		// fis에서 읽어서 fos으로 복사하기
		while ((size = fis.read(buf, 0, buf.length)) > 0) // 0보다 클때까지
			fos.write(buf, 0, size);
		fis.close();
		fos.close();
		return uploadedFileName;
	}

	@Override
	public Member getMember(String memberId) {
		return memberDao.get(memberId);
	}

}
