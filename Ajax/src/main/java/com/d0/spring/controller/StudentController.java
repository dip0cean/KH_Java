package com.d0.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.StudentDTO;
import com.d0.spring.repository.StudentDAO;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;

	@GetMapping("/insert")
	public String join() {
		
		return "student/insert";
	}
	
	@GetMapping("/list")
	public String list() {
		
		return "student/list";
	}
	
	@GetMapping("/search")
	public String search() {
		
		return "student/search";
	}
	
	@PostMapping("/insert")
	public String join(@ModelAttribute StudentDTO studentDTO) {
		studentDAO.insert(studentDTO);
		
		return "redirect:list";
	}
}
