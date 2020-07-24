package com.d0.spring_07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class MenuController {

	// jdbcTemplate 라는 도구를 사용하고 싶으면 spring 에게 부탁한다.
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/insert")
	public String insert() {
		System.out.println(jdbcTemplate);
		return "menu/insert";
	}
	
	@PostMapping("/insert")
	public String insert(
			@RequestParam String name,
			@RequestParam int price) {
		
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price);
		
		String sql = "INSERT INTO MENU VALUES(? , ?)";
		Object[] param = {name, price};
		jdbcTemplate.update(sql,param);
		
		return "redirect:/menu/insert";
	}
}
