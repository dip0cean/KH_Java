package com.d0.spring_05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") // 공용으로 사용할 주소 지정
public class MemberController {

	@RequestMapping(value = "/")
	public String index() {
		return "index"; // ViewResolver
	}

	/* @RequestMapping(value = "/join", method = RequestMethod.GET) */
	@GetMapping("/join")
	public String join() {
		return "join"; // ViewResolver
	}

	/* @RequestMapping(value = "/join", method = RequestMethod.POST) */
	@PostMapping("/join")
	public String join_finish(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nick = req.getParameter("nick");
		
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("NICK : " + nick);
		
		return "join_finish";
	}
}
