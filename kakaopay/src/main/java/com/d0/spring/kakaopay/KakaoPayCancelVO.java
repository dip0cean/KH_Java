package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayCancelVO {

	private String aid;
	private String tid;
	private String cid;
	private String status;
	private String partner_order_id;
	private String partner_user_id;
	private String payment_method_type;
	private KakaoPayFinishAmountVO amount;
	private KakaoPayFinishAmountVO canceled_amount;
	private KakaoPayFinishAmountVO cancel_available_amount;
	private String item_name;
	private String item_code;
	private String quantity;
	private String created_At;
	private String approved_at;
	private String canceled_at;
	private String payload;
}
