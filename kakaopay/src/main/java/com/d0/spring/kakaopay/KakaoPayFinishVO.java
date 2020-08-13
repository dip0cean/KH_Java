package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayFinishVO {

	private String aid, tid, cid, sid;
	private String partner_order_id, partner_user_id;
	private String payment_method_type, item_name, item_code, payload;
	private String create_at, approved_at;
	private int quantity;
	private KakaoPayFinishAmountVO amount;
	private KakaoPayFinishCardInfoVO card_info;
}
