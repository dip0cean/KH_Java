package com.d0.spring_06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring_06.entity.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login_finish(@ModelAttribute MemberDTO mdto) {
		System.out.println(mdto.getId());
		System.out.println(mdto.getPw());
		return "redirect:/";
	}
}
