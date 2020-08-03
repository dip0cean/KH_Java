package com.d0.lombok;

import org.junit.Test;

import com.d0.lombok.entity.MenuDTO;

public class Test01 {
	
	@Test // Junit 이라는 도구를 이용해서 테스팅이 가능하도록 설정
	public void test() {
		// @Setter + @Getter
		MenuDTO mdto = new MenuDTO();
		mdto.setA("치킨");
		mdto.setB("500원");
		System.out.println(mdto.getA());
		System.out.println(mdto.getB());
		
		System.out.println(mdto);
		
		// @AllArgsContructor
		MenuDTO c = new MenuDTO("a", "b");
		System.out.println(c);
		
		// @Builder
		MenuDTO b = MenuDTO.builder().a("김치킨").b("김퍼피").build();
		System.out.println(b);
	}
}
