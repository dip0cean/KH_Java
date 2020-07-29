package com.d0.spring.controller;

import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.spring.entity.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private SqlSession sqlSession;

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

		MemberDTO find = sqlSession.selectOne("member.getId", memberDTO.getMember_id());

		if (find == null) {
			// 해당 아이디가 없다면 가입
			sqlSession.insert("member.regist", memberDTO);

			return "redirect:regist_finish";
		} else {
			// 해당 아이디가 있다면 회원가입 페이지로 이동
			return "redirect:join?error";
		}
	}

	// 로그인
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}

	// 로그인 실행
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO login = sqlSession.selectOne("member.login2", memberDTO);

		if (login != null) {
			session.setAttribute("memberLogin", login);
			
			MemberDTO m = (MemberDTO) session.getAttribute("memberLogin");
			System.out.println(m.getMember_id());
			return "redirect:/";
		} else {
			return "redirect:login?error";
		}

	}
}
