package com.d0.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailService implements EmailService {
	
	@Autowired
	private JavaMailSender sender;

	// 참조 / 숨은 참조가 있을 경우 > 오버로드
	@Override
	public void sendSimpleMessage(SimpleMailMessage message) {
		sender.send(message);
		
	}

	// 참조 / 숨은 참조가 없을 경우 > 오버로드
	@Override
	public void sendSimpleMessage(String email, String title, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(email);
		message.setSubject(title);
		message.setText(text);
		
		this.sendSimpleMessage(message);
	}

}
