package com.d0.spring;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.slf4j.Slf4j;

// 직접 도구를 생성해서 이메일을 보내는 예제
@Slf4j
public class Email01 {

	private JavaMailSenderImpl sender;

	@Before // @Test 를 진행하기 전에 실행할 내용을 작성 > 준비작업
	public void prepare() {
		log.debug("Before 실행");
		
		JavaMailSenderImpl impl = new JavaMailSenderImpl();
		
		// impl 필요한 설정을 수행
		// 1. 계정 설정
		impl.setHost("smtp.gmail.com");
		impl.setPort(587);
		impl.setUsername("dev.dip0cean@gmail.com");
		impl.setPassword("Sks621604!");
		
		// 2. 옵션 설정
		Properties prop = new Properties(); // Map<Object, Object> 형태
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		
		impl.setJavaMailProperties(prop);
		
		// sender에 대입
		sender = impl;
	}
	
	@Test
	public void test() {
		log.debug("Test 실행");
		
		// 메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
		// 메세지 정보 설정 > 제목 / 내용 / 첨부파일 / 받는 이 / 참조 / 숨은 참조
		message.setSubject("테스트 메일");
		message.setText("테스트 메일 전송 성공!");
		
		String[] to = {"dip0cean@skuniv.ac.kr"};
		message.setTo(to);
		
		String[] cc = {"dip.0cean@daum.net"};
		message.setCc(cc);
		
		String[] bcc = {"dip0cean@naver.com"};
		message.setBcc(bcc);
		
		// 메세지 전송
		sender.send(message);
	}
	
	@After // @Test 이후 실행될 내용을 작성 > 마무리
	public void finish() {
		log.debug("After 실행");
	}
}
