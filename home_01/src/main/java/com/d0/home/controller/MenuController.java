package com.d0.home.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.home.entity.MenuDTO;

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

	@GetMapping("/list")
	public String list(Model model) {

		List<MenuDTO> list = sqlSession.selectList("menu.getList");
		/*
		 * Model 이라는 매개변수를 선언한 뒤 추가
		 */
		model.addAttribute("list", list);

		return "menu/list";
	}

}
