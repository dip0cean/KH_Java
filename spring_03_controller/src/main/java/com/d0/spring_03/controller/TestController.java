package com.d0.spring_03.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	// 메소드를 이용해서 컨트롤러 설정
	
	public String home() {
		return "go";
	}
}
