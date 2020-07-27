package com.d0.mybatis.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.mybatis.entity.StudentDTO;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	// 이미 등록되어 있는 객체를 불러와라
	private SqlSession sqlSession;

	@GetMapping("/regist")
	public String regist() {
		return "/student/regist";
	}

	@PostMapping("/regist")
	public String regist(@ModelAttribute StudentDTO studentDTO) {
		/*
		 * 데이터 베이스 등록 myBatis 의 sqlSession 을 이용하여 mapper 호출 및 실행
		 * sqlSession.insert("구문이름", 데이터);
		 */

		System.out.println(studentDTO.getName());
		System.out.println(studentDTO.getAge());
		System.out.println(studentDTO.getScore());

		sqlSession.insert("student.regist", studentDTO);

		return "redirect:regist";

	}

}
