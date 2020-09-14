package com.d0.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	// 연계된 모듈이 없는 독립 모듈
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		return "hello";
	}
}
