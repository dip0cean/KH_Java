package com.d0.spring.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.MenuDTO;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private SqlSession sqlSession;

	@GetMapping("/insert")
	public String insert() {
		return "menu/insert";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute MenuDTO menuDTO) {
		sqlSession.insert("menu.insert", menuDTO);
		return "redirect:insert";
	}

}
