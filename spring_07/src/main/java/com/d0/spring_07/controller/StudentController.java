package com.d0.spring_07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring_07.entity.StudentDTO;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/regist")
	public String regist() {
		
		System.out.println(jdbcTemplate);

		return "student/regist";
	}
	
	@GetMapping("/regist_result")
	public String regist_result() {
		return "/student/regist_result";
	}

	@PostMapping("/regist")
	public String regist(@ModelAttribute StudentDTO studentDTO) {
		
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,SYSDATE)";
		
		Object[] param = {studentDTO.getName(),studentDTO.getAge(), studentDTO.getScore()};
		jdbcTemplate.update(sql, param);
		
		return "redirect:/student/regist_result";
	}
}
