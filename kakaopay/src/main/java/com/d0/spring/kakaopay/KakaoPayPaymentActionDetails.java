package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayPaymentActionDetails {

	private String aid;
	private String approved_at;
	private int amount;
	private int point_amount;
	private int discount_amount;
	private String payment_action_type;
	private String payload;
	
}
