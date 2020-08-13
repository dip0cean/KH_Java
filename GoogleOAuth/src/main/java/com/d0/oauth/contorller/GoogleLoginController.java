package com.d0.oauth.contorller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleLoginController {

	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	
	@Autowired
	private OAuth2Parameters oAuth2Parameters;
	
	@RequestMapping("/home")
	public String home() {
		
		System.out.println("일단 로그인은 성공인것인지");
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String initLogin(Model model, HttpSession session) throws Exception {
		
		// 구글 Code 발행
		OAuth2Operations oAuth2Operations = googleConnectionFactory.getOAuthOperations();
				
		// 로그인 페이지 이동 url 생성
		String url = oAuth2Operations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
		
		model.addAttribute("google_url", url);
		
		return "oauth/login";
	}
	
}
