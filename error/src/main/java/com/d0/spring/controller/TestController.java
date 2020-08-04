package com.d0.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	// 오류 상황 1 : 404 에러
	@GetMapping("/error1")
	public String error1() {
		return "hello";
	}

	// 오류 상황 2 : 500 internal server error
	@GetMapping("/error2")
	public String error2() {
		int a = 10 / 0; // ArtimeticException
		
		return "hello";
	}

	// 오류 상황 3 : 500
	@GetMapping("/error3")
	public String error3() {
		int a = Integer.parseInt("hello"); // NumberFormatException
		
		return "hello";
	}
}
