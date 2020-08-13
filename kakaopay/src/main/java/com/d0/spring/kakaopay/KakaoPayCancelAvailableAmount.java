package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayCancelAvailableAmount {

	private int total;
	private int tax_free;
	private int vat;
	private int point;
	private int discount;
}
