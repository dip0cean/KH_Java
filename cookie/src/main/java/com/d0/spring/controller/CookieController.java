package com.d0.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {

	@GetMapping("/create")
	public String create(HttpServletResponse resp) {
		// 쿠키는 객체를 생성한 다음 응답 정보에 첨부해야 한다.
		// - name + value / expire 선택
		// - 쿠키는 name 과 value 가 모두 문자열만 가능하다. > 아스키코드만 가능

		Cookie cookie = new Cookie("test", "khacademy");
		cookie.setMaxAge(1 * 24 * 60 * 60);
		resp.addCookie(cookie);
		return "cookie/create";
	}

	@GetMapping("/delete")
	public String delete(HttpServletResponse resp) {
		// - 쿠키 삭세 명령어는 존재하지 않는다.
		// - 만료시간 0초로 설정 > 덮어씌운다.
		Cookie cookie = new Cookie("test", "khacademy");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		return "cookie/delete";
	}
}
