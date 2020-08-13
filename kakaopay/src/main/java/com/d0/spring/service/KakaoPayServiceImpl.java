package com.d0.spring.service;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.d0.spring.kakaopay.KakaoPayFinishVO;
import com.d0.spring.kakaopay.KakaoPayProductVO;
import com.d0.spring.kakaopay.KakaoPayReqResultVO;
import com.d0.spring.kakaopay.KakaoPayResultVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KakaoPayServiceImpl implements KakaoPayService {

	public static final String CID = "TC0ONETIME";

	@Override
	public HttpHeaders headers() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK db01df2db70eb853b7b258457318a375");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		return headers;
	}

	@Override
	public KakaoPayReqResultVO paymentReq(KakaoPayProductVO payProductVO) throws Exception {
		// 필요한 데이터를 미리 변수로 선언

		log.info("결제 테스트 - Strat");

		// 서버 <-> 서버
		// - 서버간 요청을 보내기 위해서 Spring 에서는 RestTemplate 제공

		// 1. 요청 전송을 위한 도구 생성
		RestTemplate template = new RestTemplate();

		// 2. Header 생성

		// 3. Body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", CID);
		body.add("partner_order_id", payProductVO.getPartner_order_id());
		body.add("partner_user_id", payProductVO.getPartner_user_id());
		body.add("item_name", payProductVO.getItem_name());
		body.add("quantity", String.valueOf(payProductVO.getQuantity()));
		body.add("total_amount", String.valueOf(payProductVO.getTotal_amount()));
		body.add("tax_free_amount", "20");
		// 주의 : 주소는 반드시 API 에서 승인된 URL 을 사용해야 한다.
		body.add("approval_url", "http://localhost:8080/spring/pay/approve");
		body.add("cancel_url", "http://localhost:8080/spring/pay/cancel");
		body.add("fail_url", "http://localhost:8080/spring/pay/fail");

		// 4. Header + Body
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body,
				this.headers());

		// 5. 주소 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");

		// 6. template 이용 > 요청 전송 > 카카오에게
		KakaoPayReqResultVO reqResultVO = template.postForObject(uri, entity, KakaoPayReqResultVO.class);

		log.info("reqResultVO = {}", reqResultVO);
		log.info("tid = {}", reqResultVO.getTid()); // tid > db 에 들어가야 할 정보
		log.info("next_redirect_pc_url = {}", reqResultVO.getNext_redirect_pc_url());
		log.info("created_at = {}", reqResultVO.getCreated_at());

		log.info("결제 테스트 - finish");

		return reqResultVO;
	}

	@Override
	public KakaoPayFinishVO approve(String partner_order_id, String partner_user_id, String pg_token, String tid)
			throws Exception {
		// 카카오 승인 서버에 승인 요청을 보낸다.
		// - 준비물 : order_id / user_id / tid / pg_token/ cid
		// - 결과물 : KakaoPayFinishVO.class

		// 1. Template 생성
		RestTemplate template = new RestTemplate();

		// 2. Header 생성

		// 3. Body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", CID);
		body.add("partner_order_id", partner_order_id);
		body.add("partner_user_id", partner_user_id);
		body.add("pg_token", pg_token);
		body.add("tid", tid);

		// 4. Header + Body
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body,
				this.headers());

		// 5. 주소 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");

		// 6. 준비 완료 > template 이용해서 요청 전송
		KakaoPayFinishVO finishVO = template.postForObject(uri, entity, KakaoPayFinishVO.class);

		return finishVO;
	}

	@Override
	public KakaoPayResultVO result(String tid) throws Exception {

		// RestTemplate
		RestTemplate template = new RestTemplate();

		// header

		// body
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", CID);
		body.add("tid", tid);

		// body + header
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body,
				this.headers());
		
		// 주소 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		// template 로 전송
		KakaoPayResultVO resultVO = template.postForObject(uri, entity, KakaoPayResultVO.class);
		return resultVO;
	}

}
