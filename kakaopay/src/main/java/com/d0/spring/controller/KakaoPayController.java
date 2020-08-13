package com.d0.spring.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.d0.spring.kakaopay.KakaoPayFinishVO;
import com.d0.spring.kakaopay.KakaoPayProductVO;
import com.d0.spring.kakaopay.KakaoPayReqResultVO;
import com.d0.spring.service.KakaoPayService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/pay")
public class KakaoPayController {

	@Autowired
	private KakaoPayService kakaoPayService;

	@GetMapping("/payment")
	public String payment() {

		return "pay/payment";
	}

	@PostMapping("/payment")
	public String paymentReq(@ModelAttribute KakaoPayProductVO payProductVO, HttpSession session) throws Exception {

		// 1. 판매자 / 구매자 아이디 랜덤 뽑기 (실 페이지에서는 랜덤X)
		payProductVO.setPartner_order_id(UUID.randomUUID().toString());
		payProductVO.setPartner_user_id(UUID.randomUUID().toString());

		// 2. 파라미터와 판매자 / 구매자 정보를 VO 에 담아 Service 로 전송 > 결제 요청
		KakaoPayReqResultVO reqResultVO = kakaoPayService.paymentReq(payProductVO);

		// 3. 판매자 / 구매자 / tid 정보 세션에 저장
		session.setAttribute("partner_order_id", payProductVO.getPartner_order_id());
		session.setAttribute("partner_user_id", payProductVO.getPartner_user_id());
		session.setAttribute("tid", reqResultVO.getTid());

		// 4. Service 에서 받아온 reqResultVO의 결제 페이지 url 을 redirect 로 전송
		return "redirect:" + reqResultVO.getNext_redirect_pc_url();
	}

	// 결제 성공 처리 매핑
	// - 승인 요청을 보내기 위해 필요한 정보 취합
	// - 세션 > partnet_order_id, partner_user_id, tid
	// - 파라미터 > pg_token
	// - 고유값 > CID
	@GetMapping("/succ")
	public String succ(@RequestParam String pg_token, HttpSession session) throws Exception {
		String partner_order_id = (String) session.getAttribute("partner_order_id");
		String partner_user_id = (String) session.getAttribute("partner_user_id");
		String tid = (String) session.getAttribute("tid");

		log.info("partner_order_id = {}", partner_order_id);
		log.info("partner_user_id = {}", partner_user_id);
		log.info("tid = {}", tid);
		log.info("pg_token = {}", pg_token);

		// 승인 요청 발송
		KakaoPayFinishVO finishVO = kakaoPayService.approve(partner_order_id, partner_user_id, pg_token, tid);
		
		log.info("finishVO = {}",finishVO);

		return "pay/succ";
	}

	@GetMapping("/fail")
	public String fail() {
		return "pay/fail";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "pay/cancel";
	}

}
