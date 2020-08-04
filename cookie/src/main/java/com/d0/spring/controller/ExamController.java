package com.d0.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {

	@GetMapping("/sign-in")
	public String sighIn() {

		return "exam/sign-in";
	}

	@GetMapping("/ad")
	public String ad() {
		
		return "exam/ad";
	}
}
