package com.d0.spring.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	// 간단한 이메일 발송을 해보자!
	// - 준비물 : 제목 + 내용 + 받는 이 + 참조 + 숨은 참조 > SimpleMailMessage
	// - 결과물 : void
	
	void sendSimpleMessage(SimpleMailMessage message);
	
	void sendSimpleMessage(String email, String title, String text);
}
