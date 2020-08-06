package com.d0.spring;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring + Junit4 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정 무시
@Slf4j
public class Email04 {

	// Mime Message 보내기
	// - html 형태의 메일 전송
	// - 첨부파일 전송

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws Exception {
		//log.debug("sender = " + sender);
		log.debug("sender = {}",sender);
		
		// Mime Message 생성
		MimeMessage message = sender.createMimeMessage();
		
		// Mime Message 는 형태가 복잡하기 때문에 Helper 도구 존재
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// helper 에 정보 설정
		String[] to = {"dip.0cean@daum.net"};
		helper.setTo(to);
		
		helper.setSubject("Mime Message Test");
		
		helper.setText("<h1>환영합니다.</h1> <br><br> <p style='color: red;'>저희 사이트에 가입해주셔서 감사합니다.</p><br><br><a href='http://www.sysout.co.kr/carrot_task/'><button>해당 페이지로 이동</button></a>", true);
		
		
		// 전송
		sender.send(message);
	}
}
