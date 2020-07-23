package com.d0.spring_05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring_05.entity.MemberDTO;

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

	// 기존 방식
	/* @RequestMapping(value = "/join", method = RequestMethod.POST) */
	/*
	 * @PostMapping("/join") public String join_finish(HttpServletRequest req) {
	 * String id = req.getParameter("id"); String pw = req.getParameter("pw");
	 * String nick = req.getParameter("nick");
	 * 
	 * System.out.println("ID : " + id); System.out.println("PW : " + pw);
	 * System.out.println("NICK : " + nick);
	 * 
	 * return "join_finish"; }
	 */

	// @RequestParam 사용
	/*
	 * @PostMapping("/join") public String join_finish(
	 * 
	 * @RequestParam String id,
	 * 
	 * @RequestParam String pw,
	 * 
	 * @RequestParam(required = false) String nick) { System.out.println("ID : " +
	 * id); System.out.println("PW : " + pw); System.out.println("NICK : " + nick);
	 * 
	 * return "join_finish"; }
	 */

	// 클래스 주고 자동으로 받게 하기 : @ModelAttribute
	@PostMapping("/join")
	public String join_finish(@ModelAttribute MemberDTO mdto) {
		System.out.println("ID : " + mdto.getId());
		System.out.println("PW : " + mdto.getPw());
		System.out.println("NICK : " + mdto.getNick());
		return "join_finish";
	}
}
