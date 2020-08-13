package com.d0.oauth.rest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d0.oauth.entity.OauthDTO;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/getList")
	public List<OauthDTO> test() {
		
		List<OauthDTO> list = sqlSession.selectList("oauth.getList");
		
		return list;
	}
}
