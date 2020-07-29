package com.d0.spring.controller;

import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.MemberDTO;
import com.d0.spring.repository.MemberDAO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private MemberDAO memberDAO;

	// 회원가입 페이지 (get)
	@GetMapping("/regist")
	public String regist() {
		return "member/regist";
	}

	// 회원가입 완료 페이지 (post)
	@GetMapping("/regist_finish")
	public String regist_finish() {
		return "member/regist_finish";
	}

	// 회원가입 메소드 > 아이디 검사
	@PostMapping("/regist")
	public String regist(@ModelAttribute MemberDTO memberDTO) {
		boolean result = memberDAO.join(memberDTO);

		if (result) {
			return "redirect:/";
		}

		return "redirect:regist";
	}

	// 로그인
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		boolean result = memberDAO.login(memberDTO);
		
		if (result) {
			session.setAttribute("memberLogin", memberDTO);
			return "redirect:/";
		}

		return "redirect:login?error";

	}

	// 로그아웃
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("memberLogin");

		return "redirect:/";
	}
}
