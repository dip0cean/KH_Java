package com.d0.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d0.spring.entity.CertDTO;
import com.d0.spring.repository.CertDAO;
import com.d0.spring.service.CertService;
import com.d0.spring.service.EmailService;

@Controller
@RequestMapping("/cert")
public class CertController {

	@Autowired
	private CertService certService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private CertDAO certDAO;

	@GetMapping("/input")
	public String input() {
		return "cert/input";
	}

	@PostMapping("/input")
	public String input(@RequestParam String email, HttpServletRequest req) {

		String ip = req.getRemoteAddr();

		// 인증 번호 발급
		String secret = certService.generateCertification(ip);

		// 이메일 전송
		emailService.sendSimpleMessage(email, "[아로리 | 당신의 지식] 인증번호", "인증번호 : " + secret);

		return "redirect:check";
	}

	@GetMapping("/check")
	public String check() {

		return "cert/check";
	}

	@PostMapping("/check")
	public String check(@RequestParam String secret, HttpServletRequest req, Model model) {
		
		CertDTO check = CertDTO.builder().who(req.getRemoteAddr()).secret(secret).build();
		boolean result = certDAO.validate(check);
		model.addAttribute("result", result);
		return "cert/check_result";
	}

}
