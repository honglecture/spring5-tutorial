package com.tutorial.web.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.web.entity.Member;
import com.tutorial.web.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("")
	public String home() {
		return "redirect:/member/login";
	}

	@GetMapping("login")
	public String login() {
		return "member.login";
	}

	@GetMapping("join")
	public String join() {
		return "member.join";
	}

	@PostMapping("join")
	public String join(Member member, @RequestParam("photo-file") MultipartFile photoFile, HttpServletRequest request) {
		try {
			String originalFilename = photoFile.getOriginalFilename();
			String uploadedFileName = "";
			if(!originalFilename.equals("") && originalFilename != null) {
				uploadedFileName = memberService.insertProfilePhoto(member.getId(), photoFile, request);
			}
			member.setPhoto(uploadedFileName);
			int result = memberService.insertMember(member);
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/index"; // 에러 페이지로 가야 함
		}
		return "redirect:/index";
	}

	@GetMapping("profile")
	public String profile(Model model, Principal principal) {
		String memberId = principal.getName();
		Member member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		return "member.profile";
	}

}