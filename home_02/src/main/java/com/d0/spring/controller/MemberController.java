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

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private PasswordEncoder encoder;

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
			// 가입 전 비밀번호 암호화
			// encoder.encode(비밀번호) --> 암호화된 비밀번호
			memberDTO.setMember_pw(encoder.encode(memberDTO.getMember_pw()));

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

	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		// 1. DB 에서 해당 회원의 정보를 모두 불러온다.
		MemberDTO find = sqlSession.selectOne("member.getId", memberDTO.getMember_id());

		if (find != null) {
			// 2. 아이디가 있을 경우 비밀번호 비교를 수행한다. (encoder 이용)
			// encoder.matches(입력pw, dbpw);
			boolean pass = encoder.matches(memberDTO.getMember_pw(), find.getMember_pw());

			if (pass) {
				// 3. 비밀번호 비교
				session.setAttribute("memberLogin", find);
				return "redirect:/";
			}
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
