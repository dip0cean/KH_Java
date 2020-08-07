package com.d0.spring;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.d0.spring.entity.CertDTO;
import com.d0.spring.repository.CertDAO;
import com.d0.spring.service.CertService;
import com.d0.spring.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring + Junit4 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정 무시
@Slf4j
public class Test06 {

	@Autowired
	private CertDAO certDAO;
	
	@Autowired
	private CertService certService;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private EmailService emailService;
	
	private String secret;
	
	@Before
	public void pre() {
		secret = certService.generateCertification("127.0.0.1");
		
		emailService.sendSimpleMessage("dip.0cean@daum.net", "인증번호 메일 테스트", secret);
		
		log.debug("secret = {}", secret);
	}

	@Test
	public void test() {
		
		log.debug("테스트 시작!");
		
		CertDTO certDTO = CertDTO.builder().who("127.0.0.1").secret(secret).build();
		boolean result = certDAO.validate(certDTO);
		
		if(result) sqlSession.delete("cert.delete",certDTO);
		
		log.debug("result = {}", result);
	}
}
