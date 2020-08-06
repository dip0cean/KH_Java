package com.d0.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.d0.spring.service.CertService;
import com.d0.spring.service.EmailService;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class) // Spring + Junit4 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정 무시
@Slf4j
public class Test04 {

	@Autowired
	private CertService certService;
	
	@Autowired
	private EmailService emailService;

	@Test
	public void test() {
		
		String ip = "127.0.0.1";
		
		String code = certService.generateCertification(ip);
		
		String email = "dip.0cean@daum.net";
		String title = "비밀번호 인증 메일";
		String text = "인증번호 : " + code;
		
		emailService.sendSimpleMessage(email, title, text);
		
		log.debug("code = {}", code);
	}
}
