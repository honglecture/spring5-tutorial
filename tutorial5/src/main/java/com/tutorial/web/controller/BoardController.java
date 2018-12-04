package com.tutorial.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@GetMapping("")
	public String home() {
		return "redirect:/board/list";
	}

	@GetMapping("list")
	public String list() {
		return "board.list";
	}

	@GetMapping("detail")
	public String detail() {
		return "board.detail";
	}

	@GetMapping("reg")
	public String reg() {
		return "board.reg";
	}

	@GetMapping("edit")
	public String edit() {
		return "board.edit";
	}

}
