package com.d0.spring.kakaopay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPaySelectedCardInfo {

	private String card_bin;
	private int install_month;
	private String card_corp_name;
	private String interest_free_install;
}
