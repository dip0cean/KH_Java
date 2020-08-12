package com.d0.spring;

import java.net.URI;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test01 {

	// 1번 테스트
	// - 서버 간의 연결하기
	// - 카카오 API '결제 준비' 요청 보내기

	@Test
	public void test() throws Exception {
		log.info("결제 테스트 - Strat");

		// 서버 <-> 서버
		// - 서버간 요청을 보내기 위해서 Spring 에서는 RestTemplate 제공

		// 1. 요청 전송을 위한 도구 생성
		RestTemplate template = new RestTemplate();

		// 2. Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK db01df2db70eb853b7b258457318a375");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 3. Body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", "TC0ONETIME");
		body.add("partner_order_id", "partner_order_id");
		body.add("partner_user_id", "partner_user_id");
		body.add("item_name", "노동환 대장 융털");
		body.add("quantity","1");
		body.add("total_amount", "100");
		body.add("tax_free_amount", "20");
		// 주의 : 주소는 반드시 API 에서 승인된 URL 을 사용해야 한다.
		body.add("approval_url", "http://localhost:8080/spring/");
		body.add("cancel_url", "http://localhost:8080/spring/");
		body.add("fail_url", "http://localhost:8080/spring/");

		// 4. Header + Body
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body, headers);

		// 5. 주소 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		// 6. template 이용 > 요청 전송 > 카카오에게
		template.postForLocation(uri, entity);

		log.info("결제 테스트 - finish");
	}
}
