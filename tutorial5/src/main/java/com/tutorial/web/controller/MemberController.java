package com.tutorial.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {

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

	@GetMapping("profile")
	public String profile() {
		return "member.profile";
	}

}