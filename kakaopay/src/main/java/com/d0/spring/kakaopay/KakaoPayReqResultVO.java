package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 해당 클래스는 "결제 요청" 에 대한 결과를 저장하는 클래스입니다.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayReqResultVO {
	
	private String tid;
	private String next_redirect_pc_url;
	private String created_at;

}
