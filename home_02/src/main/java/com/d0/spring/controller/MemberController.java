package com.d0.spring.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@GetMapping("/regist")
	public String regist() {
		return "member/regist";
	}

	@PostMapping("/regist")
	public String regist(@ModelAttribute MemberDTO memberDTO) {
		
		MemberDTO find = sqlSession.selectOne("member.getId",memberDTO.getMember_id());

		if(find == null) {
			// 해당 아이디가 없다면 가입
			sqlSession.insert("member.regist", memberDTO);
			
			return "redirect:list";
		} else {
			// 해당 아이디가 있다면 회원가입 페이지로 이동
			return "redirect:join?error";
		}
 
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<MemberDTO> list = sqlSession.selectList("member.getList");
		
		model.addAttribute("memberList", list);
		
		return "member/list";
	}
}
