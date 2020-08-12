package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 해당 클래스는 최초 카카오 페이 '결제 요청' 을 위한 정보를 저장하는 클래스입니다.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayProductVO {
	private String partner_order_id;
	private String partner_user_id;
	private String item_name;
	private int quantity;
	private int total_amount;
}
