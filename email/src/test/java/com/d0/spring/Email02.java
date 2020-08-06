package com.d0.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class) // Spring + Junit4 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정 무시
@Slf4j
public class Email02 {

	@Autowired
	private JavaMailSenderImpl sender;

	@Test
	public void test() {

		// 메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();

		// 메세지 정보 설정 > 제목 / 내용 / 첨부파일 / 받는 이 / 참조 / 숨은 참조
		message.setSubject("테스트 메일");
		message.setText("와우! 어메이징 스파이더맨! 테스트 메일 전송 성공!");

		String[] to = { "dip0cean@skuniv.ac.kr" };
		message.setTo(to);

		String[] cc = { "dip.0cean@daum.net" };
		message.setCc(cc);

		String[] bcc = { "dip0cean@naver.com" };
		message.setBcc(bcc);

		// 메세지 전송
		sender.send(message);
		
		log.debug("테스트 성공");
	}

}
