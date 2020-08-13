package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayResultVO {

	private String tid;
	private String cid;
	private String status;
	private String partner_order_id;
	private String partner_user_id;
	private String payment_method_type;
	private KakaoPayFinishAmountVO amount;
	
	private String item_name;
	private String item_code;
	private int quantity;
	private String create_at;
	private String approved_at;
	private String canceled_at;
	private KakaoPaySelectedCardInfo selected_card_info;
	
	private KakaoPayPaymentActionDetails[] payment_action_details;
	
	private KakaoPayFinishAmountVO canceled_amount;
	private KakaoPayFinishAmountVO cancel_available_amount;
}
