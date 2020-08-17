package com.d0.oauth.rest;

import java.util.Iterator;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	
	@PostMapping("/upload")
	public void upload(MultipartHttpServletRequest req) {
		// Stream 에서 넘어온 byte[] > Iterator 반복자를 이용해 합쳐주는 역할? 
		// 받아온 매개 변수 > Service 로 이동 
		// Service 에서 파일 저장 + DB에 데이터 저장 후 해당 파일 번호 반환 
		Iterator<String> test = req.getFileNames();
		if(test.hasNext()) {
			MultipartFile mpf = req.getFile(test.next());
			System.out.println(mpf.getOriginalFilename());
			System.out.println(mpf.getSize());
			System.out.println(mpf.getContentType());
		}
		
		
		System.out.println("데이터가 오기를 바랄 뿐");
	}
}
