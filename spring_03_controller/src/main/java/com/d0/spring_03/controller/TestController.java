package com.d0.spring_03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	// 메소드를 이용해서 컨트롤러 설정

	@RequestMapping(value = "/home")
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}

	@RequestMapping(value = "/test")
	public String test() {
		return "/WEB-INF/views/test.jsp";
	}

	@RequestMapping(value = "/check")
	public String check() {
		return "/WEB-INF/views/check.jsp";
	}

	@RequestMapping(value = "/member")
	public String member() {
		return "/WEB-INF/views/member.jsp";
	}

	@RequestMapping(value = "/board")
	public String board() {
		return "/WEB-INF/views/board.jsp";
	}
}
