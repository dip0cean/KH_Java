package com.d0.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 해당 컨트롤러는 JSP 등 각종 모듈을 연동하여 사용하는 컨트롤러
 * - 테스트할 때 Standalone 방식으로는 불가능
 * - 스프링의 모든 환경 정보를 불러와서 연결 시켜 테스트 진
 * */
@Controller
public class ApplicationController {

	@GetMapping("/application")
	public String app() {
		return "hello";
	}
}
