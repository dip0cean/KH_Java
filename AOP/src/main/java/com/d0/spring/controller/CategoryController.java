package com.d0.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.CategoryDTO;
import com.d0.spring.repository.CategoryDAO;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@GetMapping("/add")
	public String add() {
		return "category/add";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute CategoryDTO categoryDTO) {
		
		categoryDAO.add(categoryDTO);
		
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<CategoryDTO> list = categoryDAO.getList();
		model.addAttribute("categoryList", list);
		return "category/list";
	}

}
