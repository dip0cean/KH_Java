package com.d0.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.d0.spring.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/send")
	public String send() {
		return "email/send";
	}
	
	@PostMapping("/send")
	public String send(@RequestParam String email, @RequestParam String title, @RequestParam String text) {
		
		emailService.sendSimpleMessage(email, title, text);
		
		return "redirect:/";
	}
}
