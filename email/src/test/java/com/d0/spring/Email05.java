package com.d0.spring;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
public class Email05 {

	@Autowired
	private JavaMailSender sender;

	@Test
	public void test() throws Exception {
		// Mime Message 를 이용한 파일 첨부
		// - javax.actvation.DataSource > 파일 정보!
		log.debug("sender = {}", sender);

		MimeMessage message = sender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		String[] to = {"dip.0cean@daum.net"};
		helper.setTo(to);
		helper.setSubject("파일 전송 테스트");
		helper.setText("<h1>환영합니다.</h1> <br><br> <p style='color: red;'>저희 사이트에 가입해주셔서 감사합니다.</p><br><br><a href='http://www.naver.com/'><button></button></a>", true);

		// 첨부 파일 추가
		DataSource source = new FileDataSource("C:/Users/user1/Desktop/오구1.jpg");
		helper.addAttachment(source.getName(), source);
		
		sender.send(message);
	}
}
