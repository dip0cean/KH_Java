package com.d0.spring.service;

import org.springframework.http.HttpHeaders;

import com.d0.spring.kakaopay.KakaoPayFinishVO;
import com.d0.spring.kakaopay.KakaoPayProductVO;
import com.d0.spring.kakaopay.KakaoPayReqResultVO;
import com.d0.spring.kakaopay.KakaoPayResultVO;

public interface KakaoPayService {
	
	public HttpHeaders headers();

	public KakaoPayReqResultVO paymentReq(KakaoPayProductVO payProductVO) throws Exception;

	public KakaoPayFinishVO approve(String partner_order_id, String partner_user_id, String pg_token, String tid) throws Exception;

	public KakaoPayResultVO result(String tid) throws Exception;
}
