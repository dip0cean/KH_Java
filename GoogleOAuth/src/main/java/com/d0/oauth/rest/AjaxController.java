package com.d0.oauth.rest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.d0.oauth.entity.OauthDTO;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/getList")
	public OauthDTO test(@RequestParam String email) {
		
		OauthDTO oauthDTO = sqlSession.selectOne("oauth.get", email);
		
		return oauthDTO;
	}
}
