package com.d0.oauth.contorller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.d0.oauth.entity.OauthDTO;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/test01")
	public String test01(Model model) {
		
		List<OauthDTO> list = sqlSession.selectList("oauth.getList");
		
		model.addAttribute("getList", list);
		
		return "test/test";
	}
	
	@GetMapping("/join")
	public String join() {
		
		return "test/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute OauthDTO oauthDTO) {
		
		System.out.println(oauthDTO.getEmail());
		
		sqlSession.insert("oauth.join", oauthDTO);
		
		return "redirect:test01";
				
	}
}
