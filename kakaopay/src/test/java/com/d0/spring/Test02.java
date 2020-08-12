package com.d0.spring;

import java.net.URI;
import java.util.UUID;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.d0.spring.kakaopay.KakaoPayProductVO;
import com.d0.spring.kakaopay.KakaoPayReqResultVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test02 {

	// 2번 테스트
	// - 변하는 값들을 변수화
	// - 카카오 API '결제 준비' 요청 보내기 + 요청 결과 확인

	@Test
	public void test() throws Exception {
		// 필요한 데이터를 미리 변수로 선언
		KakaoPayProductVO productVO = KakaoPayProductVO.builder().partner_order_id(UUID.randomUUID().toString()).partner_user_id(UUID.randomUUID().toString())
				.item_name("냠냠굿").quantity(1).total_amount(10000).build();

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
		body.add("partner_order_id", productVO.getPartner_order_id());
		body.add("partner_user_id", productVO.getPartner_user_id());
		body.add("item_name", productVO.getItem_name());
		body.add("quantity", String.valueOf(productVO.getQuantity()));
		body.add("total_amount", String.valueOf(productVO.getTotal_amount()));
		body.add("tax_free_amount", "20");
		// 주의 : 주소는 반드시 API 에서 승인된 URL 을 사용해야 한다.
		body.add("approval_url", "http://localhost:8080/spring/succ");
		body.add("cancel_url", "http://localhost:8080/spring/cancel");
		body.add("fail_url", "http://localhost:8080/spring/fail");

		// 4. Header + Body
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body, headers);

		// 5. 주소 정의
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");

		// 6. template 이용 > 요청 전송 > 카카오에게
		KakaoPayReqResultVO reqResultVO = template.postForObject(uri, entity, KakaoPayReqResultVO.class);
		
		log.info("reqResultVO = {}", reqResultVO);
		log.info("tid = {}",reqResultVO.getTid()); // tid > db 에 들어가야 할 정보
		log.info("next_redirect_pc_url = {}",reqResultVO.getNext_redirect_pc_url());
		log.info("created_at = {}", reqResultVO.getCreated_at());

		log.info("결제 테스트 - finish");
	}
}
